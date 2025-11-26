package com.service.support.servicesupport_be_v1.web.controller;

import com.service.support.servicesupport_be_v1.mapper.OwnerCompanyMapper;
import com.service.support.servicesupport_be_v1.persistance.entity.OwnerCompanyEntity;
import com.service.support.servicesupport_be_v1.service.entity.OwnerCompanyService;
import com.service.support.servicesupport_be_v1.web.api.OwnerCompanyApi;
import com.service.support.servicesupport_be_v1.web.model.OwnerCompany;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OwnerCompanyController implements OwnerCompanyApi {

    private final OwnerCompanyService service;
    private final OwnerCompanyMapper mapper;

    public OwnerCompanyController(OwnerCompanyService service, OwnerCompanyMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<List<OwnerCompany>> ownerCompaniesActiveGet() {
        return ResponseEntity.ok(mapper.toDtoList(service.findAllByActiveTrue()));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<OwnerCompany>> ownerCompaniesGet() {
        return ResponseEntity.ok(mapper.toDtoList(service.findAll()));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> ownerCompaniesIdDelete(Integer id) {
        OwnerCompanyEntity entity = service.findById(id.longValue());
        service.softDelete(entity.getId());
        return ResponseEntity.noContent().build();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN_ROLE')")
    public ResponseEntity<OwnerCompany> ownerCompaniesIdGet(Integer id) {
        OwnerCompanyEntity entity = service.findById(id.longValue());
        return ResponseEntity.ok(mapper.toDto(entity));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<OwnerCompany> ownerCompaniesIdPut(Integer id, OwnerCompany ownerCompany) {
        OwnerCompanyEntity existing = service.findById(id.longValue());

        OwnerCompanyEntity entity = mapper.toEntity(ownerCompany);
        entity.setId(existing.getId());
        OwnerCompanyEntity saved = service.save(entity);

        return ResponseEntity.ok(mapper.toDto(saved));
    }


    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<OwnerCompany> ownerCompaniesPost(OwnerCompany ownerCompany) {
        OwnerCompanyEntity saved = service.save(mapper.toEntity(ownerCompany));
        return ResponseEntity.ok(mapper.toDto(saved));
    }
}
