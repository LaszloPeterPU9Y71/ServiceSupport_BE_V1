package com.service.support.servicesupport_be_v1.config.security;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityWhitelist {

    public static final String[] ENDPOINTS_WHITELIST = {
            "/login",
            "/users/**",
            "/users/password-with-token/**",
            "/api/health",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resources/**"
    };
}
