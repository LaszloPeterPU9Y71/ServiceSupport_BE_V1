package com.service.support.servicesupport_be_v1.web.controller;

import com.service.support.servicesupport_be_v1.mapper.SparePartsMapper;
import com.service.support.servicesupport_be_v1.persistance.entity.SparePartsEntity;
import com.service.support.servicesupport_be_v1.service.entity.SparePartsService;
import com.service.support.servicesupport_be_v1.web.api.SparePartApi;
import com.service.support.servicesupport_be_v1.web.model.SparePart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SparePartsController implements SparePartApi {

    private final SparePartsService service;
    private final SparePartsMapper mapper;

    public SparePartsController(SparePartsService service, SparePartsMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }



    @Override
    public ResponseEntity<SparePart> sparePartsIdGet(Integer id) {
        return ResponseEntity.ok(mapper.toDto(service.findById(id.longValue())));
    }

    @Override
    public ResponseEntity<SparePart> sparePartsPost(SparePart sparePart) {
        SparePartsEntity saved = service.create(mapper.toEntity(sparePart));
        return ResponseEntity.status(201).body(mapper.toDto(saved));
    }

    @Override
    public ResponseEntity<SparePart> sparePartsIdPut(Integer id, SparePart sparePart) {
        SparePartsEntity updated = service.update(id.longValue(), mapper.toEntity(sparePart));
        return ResponseEntity.ok(mapper.toDto(updated));
    }

    @Override
    public ResponseEntity<List<SparePart>> sparePartsGet(String name) {
        if (name != null && !name.isBlank()) {
            return ResponseEntity.ok(mapper.toDtoList(service.findByName(name)));
        } else {
            return ResponseEntity.ok(mapper.toDtoList(service.findAll()));
        }
    }


    @Override
    public ResponseEntity<Void> sparePartsIdDelete(Integer id) {
        service.delete(id.longValue());
        return ResponseEntity.noContent().build();
    }



}
