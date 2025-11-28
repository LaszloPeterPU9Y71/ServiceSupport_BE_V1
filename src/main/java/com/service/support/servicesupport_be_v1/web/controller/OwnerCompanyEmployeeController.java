package com.service.support.servicesupport_be_v1.web.controller;

import com.service.support.servicesupport_be_v1.mapper.OwnerCompanyEmployeeMapper;
import com.service.support.servicesupport_be_v1.persistance.entity.OwnerCompanyEmployeeEntity;
import com.service.support.servicesupport_be_v1.service.entity.OwnerCompanyEmployeeService;
import com.service.support.servicesupport_be_v1.web.api.OwnerCompanyEmployeeApi;
import com.service.support.servicesupport_be_v1.web.model.OwnerCompanyEmployee;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OwnerCompanyEmployeeController implements OwnerCompanyEmployeeApi {

    private final OwnerCompanyEmployeeService service;
    private final OwnerCompanyEmployeeMapper mapper;

    public OwnerCompanyEmployeeController(OwnerCompanyEmployeeService service, OwnerCompanyEmployeeMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<List<OwnerCompanyEmployee>> ownerCompanyEmployeesActiveGet() {
        return ResponseEntity.ok(mapper.toDtoList(service.findAllByActiveTrue()));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<OwnerCompanyEmployee>> ownerCompanyEmployeesGet() {
        return ResponseEntity.ok(mapper.toDtoList(service.findAll()));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<OwnerCompanyEmployee> ownerCompanyEmployeesIdGet(Integer id) {
        return ResponseEntity.ok(mapper.toDto(service.findById(id.longValue())));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<OwnerCompanyEmployee> ownerCompanyEmployeesPost(OwnerCompanyEmployee employee) {
        OwnerCompanyEmployeeEntity saved = service.create(mapper.toEntity(employee));
        return ResponseEntity.ok(mapper.toDto(saved));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<OwnerCompanyEmployee> ownerCompanyEmployeesIdPut(Integer id, OwnerCompanyEmployee employee) {
        return ResponseEntity.ok(mapper.toDto(service.update(id.longValue(),employee)));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> ownerCompanyEmployeesIdDelete(Integer id) {
        service.SoftDelete(id.longValue());
        return ResponseEntity.noContent().build();
    }
}
