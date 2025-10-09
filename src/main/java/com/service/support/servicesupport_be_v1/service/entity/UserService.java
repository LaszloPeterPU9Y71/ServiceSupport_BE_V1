package com.service.support.servicesupport_be_v1.service.entity;

import com.service.support.servicesupport_be_v1.exception.EmailSendException;
import com.service.support.servicesupport_be_v1.exception.ResourceNotFoundException;
import com.service.support.servicesupport_be_v1.mapper.UserMapper;
import com.service.support.servicesupport_be_v1.persistance.entity.PasswordResetTokenEntity;
import com.service.support.servicesupport_be_v1.persistance.entity.RoleEntity;
import com.service.support.servicesupport_be_v1.persistance.entity.UserEntity;
import com.service.support.servicesupport_be_v1.persistance.repository.PasswordResetTokenRepository;
import com.service.support.servicesupport_be_v1.persistance.repository.RoleRepository;
import com.service.support.servicesupport_be_v1.persistance.repository.UserRepository;
import com.service.support.servicesupport_be_v1.web.model.MeResponse;
import com.service.support.servicesupport_be_v1.web.model.RegisterUserRequest;
import com.service.support.servicesupport_be_v1.web.model.User;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordResetTokenRepository tokenRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder; // @Bean BCryptPasswordEncoder
    private final EmailingService emailingService;

    public List<User> getAllUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    public MeResponse findUserWithRolesByEmail(String email) {
        UserEntity entity = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + email));

        List<String> roles = entity.getRoles().stream()
                .map(role -> "ROLE_" + role.getName())
                .toList();

        return new MeResponse()
                .email(entity.getEmail())
                .fullName(entity.getFullName())
                .roles(roles);

    }

    public void banUser(int userId) {
        UserEntity user = userRepository.findById((long) userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setEnabled(false);
        userRepository.save(user);
    }

    public void unbanUser(int userId) {
        UserEntity user = userRepository.findById((long) userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setEnabled(true);
        userRepository.save(user);
    }

    @Transactional
    public User registerUser(RegisterUserRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        UserEntity entity = UserEntity.builder()
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .position(request.getPosition())
                .enabled(true)
                .build();

        UserEntity saved = userRepository.save(entity);

        return userMapper.toDto(saved);
    }


    @Transactional
    public void changePassword(long userId, String oldPassword, String newPassword) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));

        if (!passwordEncoder.matches(oldPassword, user.getPasswordHash())) {
            throw new IllegalArgumentException("Password does not match");
        }

        user.setPasswordHash(passwordEncoder.encode(newPassword));
    }


    @Transactional
    public void changePasswordWithToken(String email, String token, String newPassword) {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + email));

        PasswordResetTokenEntity tokenEntity = tokenRepository.findByUser(user)
                .orElseThrow(() -> new IllegalArgumentException("No reset token for this user"));

        // ellenőrzés
        if (!tokenEntity.getToken().equals(token)) {
            throw new IllegalArgumentException("Invalid token");
        }
        if (tokenEntity.isExpired()) {
            tokenRepository.delete(tokenEntity); // lejárt → töröljük
            throw new IllegalArgumentException("Token expired");
        }

        // jelszó frissítés
        user.setPasswordHash(passwordEncoder.encode(newPassword));

        // token törlése, hogy ne lehessen újra felhasználni
        tokenRepository.delete(tokenEntity);
    }


    @Transactional
    public void setPassword(long userId, String rawPassword) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));
        user.setPasswordHash(passwordEncoder.encode(rawPassword));
    }


    @Transactional
    public void forgotPassword(String email) {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));

        // keresünk meglévő tokent a userhez
        Optional<PasswordResetTokenEntity> existing = tokenRepository.findByUser(user);

        if (existing.isPresent()) {
            PasswordResetTokenEntity tokenEntity = existing.get();
            if (!tokenEntity.isExpired()) {
                // még érvényes → visszaadjuk ugyanazt
                try {
                    emailingService.sendHtmlEmail(email, "Forgot password", "Set your password with this token: " + tokenEntity.getToken());
                } catch (MessagingException e) {
                    throw new EmailSendException("Email failed", e);
                }

                return;
            } else {
                // lejárt → töröljük
                tokenRepository.delete(tokenEntity);
            }
        }

        // új token generálás
        PasswordResetTokenEntity newToken = PasswordResetTokenEntity.builder()
                .user(user)
                .token(UUID.randomUUID().toString()) // vagy secure random string
                .validUntil(LocalDateTime.now().plusMinutes(15))
                .build();

        tokenRepository.save(newToken);

        try {
            emailingService.sendHtmlEmail(email, "Elfelejtett jelszó token", "Ezt a karaktersorozatot másold be a megfelelő helyre " + newToken.getToken());
        } catch (MessagingException e) {
            throw new EmailSendException("Email failed", e);
        }
    }

    @Transactional
    public void assignRole(long userId, String roleName) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));
        RoleEntity role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new IllegalArgumentException("Role not found: " + roleName));

        if (!user.getRoles().contains(role)) {
            user.getRoles().add(role);
        }
    }

    @Transactional
    public User removeRole(long userId, String roleName) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));

        RoleEntity role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new IllegalArgumentException("Role not found: " + roleName));

        user.getRoles().remove(role);
        userRepository.save(user);

        return userMapper.toDto(user);
    }



    public UserEntity findById(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
    }


}
