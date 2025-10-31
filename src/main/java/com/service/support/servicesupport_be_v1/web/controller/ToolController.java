package com.service.support.servicesupport_be_v1.web.controller;

import com.service.support.servicesupport_be_v1.mapper.ToolMapper;
import com.service.support.servicesupport_be_v1.persistance.entity.ToolEntity;
import com.service.support.servicesupport_be_v1.service.entity.ToolService;
import com.service.support.servicesupport_be_v1.web.api.ToolApi;
import com.service.support.servicesupport_be_v1.web.model.Tool;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ToolController implements ToolApi {

    private final ToolService service;
    private final ToolMapper mapper;


    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Tool>> toolsGet() {
        return ResponseEntity.ok(service.findAllDto());
    }


    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> toolsIdDelete(Integer id) {
        service.delete(id.longValue());
        return ResponseEntity.noContent().build();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Tool> toolsIdGet(Integer id) {
        ToolEntity entity = service.findById(id.longValue());
        return ResponseEntity.ok(mapper.toDto(entity));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Tool> toolsIdPut(Integer id, Tool tool) {
        ToolEntity updated = service.update(id.longValue(), tool);
        return ResponseEntity.ok(mapper.toDto(updated));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Tool> toolsPost(Tool tool) {
        ToolEntity saved = service.create(tool);
        return ResponseEntity.status(201).body(mapper.toDto(saved));
    }
}
