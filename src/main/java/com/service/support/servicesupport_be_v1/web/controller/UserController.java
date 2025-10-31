package com.service.support.servicesupport_be_v1.web.controller;

import com.service.support.servicesupport_be_v1.service.entity.UserService;
import com.service.support.servicesupport_be_v1.web.api.UserApi;
import com.service.support.servicesupport_be_v1.web.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<User> assignRole(Integer id, String roleName) {
        userService.assignRole(id.longValue(), roleName);
        User updated = userService.getAllUsers().stream()
                .filter(u -> u.getId().equals(id.longValue()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
        return ResponseEntity.ok(updated);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> banUser(Integer id) {
        userService.banUser(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> changePassword(Integer id, ChangePasswordRequest changePasswordRequest) {
        userService.changePassword(id.longValue(),
                changePasswordRequest.getOldPassword(),
                changePasswordRequest.getNewPassword());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> changePasswordWithToken(ChangePasswordWithTokenRequest changePasswordWithTokenRequest) {
        userService.changePasswordWithToken(changePasswordWithTokenRequest.getEmail(),
                changePasswordWithTokenRequest.getToken(),
                changePasswordWithTokenRequest.getNewPassword());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ForgotPassword200Response> forgotPassword(ForgotPasswordRequest forgotPasswordRequest) {
        userService.forgotPassword(forgotPasswordRequest.getEmail());
        // itt most csak üzenetet és token meta infót adunk vissza
        ForgotPassword200Response response = new ForgotPassword200Response()
                .message("If the email exists, a reset token has been created and sent.");
        return ResponseEntity.ok(response);
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<MeResponse> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof UserDetails userDetails)) {
            return ResponseEntity.status(401).build();
        }

        MeResponse me = userService.findUserWithRolesByEmail(userDetails.getUsername());
        return ResponseEntity.ok(me);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<User> registerUser(RegisterUserRequest registerUserRequest) {
        User user = userService.registerUser(registerUserRequest);
        return ResponseEntity.ok(user);
    }



    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<User> removeRole(Integer id, String roleName) {
        User updated = userService.removeRole(id.longValue(), roleName);
        return ResponseEntity.ok(updated);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> setPassword(Integer id, SetPasswordRequest setPasswordRequest) {
        userService.setPassword(id.longValue(), setPasswordRequest.getPassword());
        return ResponseEntity.ok().build();
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> unbanUser(Integer id) {
        userService.unbanUser(id);
        return ResponseEntity.ok().build();
    }
}