package com.service.support.servicesupport_be_v1.web.controller;

import com.service.support.servicesupport_be_v1.web.api.HealthApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController implements HealthApi {


    @Override
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("OK");
    }
}

