package com.service.support.servicesupport_be_v1.web.controller;

import com.service.support.servicesupport_be_v1.exception.UserBannedException;
import com.service.support.servicesupport_be_v1.persistance.entity.UserEntity;
import com.service.support.servicesupport_be_v1.persistance.repository.UserRepository;
import com.service.support.servicesupport_be_v1.service.security.JwtService;
import com.service.support.servicesupport_be_v1.web.api.AuthApi;
import com.service.support.servicesupport_be_v1.web.model.LoginRequest;
import com.service.support.servicesupport_be_v1.web.model.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;


    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            UserEntity user = userRepository.findByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            if (!userDetails.isEnabled()){
                throw new UserBannedException("User is banned");
            }
            String token = jwtService.generateToken(userDetails,user);

            return ResponseEntity.ok(new LoginResponse().token(token));
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }
}

