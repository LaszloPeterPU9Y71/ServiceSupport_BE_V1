package com.service.support.servicesupport_be_v1.web.controller;

import com.service.support.servicesupport_be_v1.mapper.RoleMapper;
import com.service.support.servicesupport_be_v1.persistance.repository.RoleRepository;
import com.service.support.servicesupport_be_v1.service.entity.RoleService;
import com.service.support.servicesupport_be_v1.web.api.RoleApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleController implements RoleApi {

    private final RoleService roleService;
    private final RoleMapper roleMapper;

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<String>> getAllRoles() {
        return ResponseEntity.ok( roleMapper.toDtoList(roleService.findAll()));

    }
}
