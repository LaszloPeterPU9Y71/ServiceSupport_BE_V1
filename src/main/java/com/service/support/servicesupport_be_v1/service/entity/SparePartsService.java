package com.service.support.servicesupport_be_v1.service.entity;

import com.service.support.servicesupport_be_v1.exception.ResourceNotFoundException;
import com.service.support.servicesupport_be_v1.persistance.entity.SparePartsEntity;
import com.service.support.servicesupport_be_v1.persistance.repository.SparePartsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SparePartsService {

    private final SparePartsRepository repository;


    public List<SparePartsEntity> findAll() {
        return repository.findAll();
    }

    public SparePartsEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Spare part not found with id " + id));
    }

    public List<SparePartsEntity> findByName(String name) {
        return repository.findByItemNameContainingIgnoreCase(name);
    }

    public SparePartsEntity create(SparePartsEntity sparePart) {
        return repository.save(sparePart);
    }

    public SparePartsEntity update(Long id, SparePartsEntity sparePart) {
        SparePartsEntity existing = findById(id);
        sparePart.setId(existing.getId());
        return repository.save(sparePart);
    }

    public void delete(Long id) {
        SparePartsEntity existing = findById(id);
        repository.delete(existing);
    }
}

