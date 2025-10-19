package com.service.support.servicesupport_be_v1.web.controller;

import com.service.support.servicesupport_be_v1.mapper.OwnerCompanyEmployeeMapper;
import com.service.support.servicesupport_be_v1.service.entity.OwnerCompanyEmployeeService;
import com.service.support.servicesupport_be_v1.web.api.OwnerCompanyEmployeeApi;
import com.service.support.servicesupport_be_v1.web.model.OwnerCompanyEmployee;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<OwnerCompanyEmployee>> ownerCompanyEmployeesGet() {
        return ResponseEntity.ok(mapper.toDtoList(service.findAll()));
    }

    @Override
    public ResponseEntity<OwnerCompanyEmployee> ownerCompanyEmployeesIdGet(Integer id) {
        return ResponseEntity.ok(mapper.toDto(service.findById(id.longValue())));
    }

    @Override
    public ResponseEntity<OwnerCompanyEmployee> ownerCompanyEmployeesPost(OwnerCompanyEmployee employee) {
        return ResponseEntity.ok(mapper.toDto(service.create(employee)));
    }

    @Override
    public ResponseEntity<OwnerCompanyEmployee> ownerCompanyEmployeesIdPut(Integer id, OwnerCompanyEmployee employee) {
        return ResponseEntity.ok(mapper.toDto(service.update(id.longValue(),employee)));
    }

    @Override
    public ResponseEntity<Void> ownerCompanyEmployeesIdDelete(Integer id) {
        service.delete(id.longValue());
        return ResponseEntity.noContent().build();
    }
}
