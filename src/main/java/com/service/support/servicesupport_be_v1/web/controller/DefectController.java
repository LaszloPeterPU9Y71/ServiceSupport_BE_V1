package com.service.support.servicesupport_be_v1.web.controller;

import com.service.support.servicesupport_be_v1.mapper.DefectMapper;
import com.service.support.servicesupport_be_v1.persistance.entity.DefectEntity;
import com.service.support.servicesupport_be_v1.service.entity.DefectService;
import com.service.support.servicesupport_be_v1.web.api.DefectApi;
import com.service.support.servicesupport_be_v1.web.model.Defect;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DefectController implements DefectApi {

    private final DefectService service;
    private final DefectMapper mapper;


    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Defect>> defectsGet() {
        return ResponseEntity.ok(mapper.toDtoList(service.findAll()));
    }

    @Override
    public ResponseEntity<Void> defectsIdDelete(Integer id) {
        service.delete(id.longValue());
        return ResponseEntity.noContent().build();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Defect> defectsIdGet(Integer id) {
        DefectEntity entity = service.findById(id.longValue());
        return ResponseEntity.ok(mapper.toDto(entity));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Defect> defectsIdPut(Integer id, Defect defect) {
        DefectEntity updated = service.update(id.longValue(), mapper.toEntity(defect));
        return ResponseEntity.ok(mapper.toDto(updated));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Defect> defectsPost(Defect defect) {
        DefectEntity saved = service.create(mapper.toEntity(defect));
        return ResponseEntity.status(201).body(mapper.toDto(saved));
    }
}
