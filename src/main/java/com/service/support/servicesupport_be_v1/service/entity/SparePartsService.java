package com.service.support.servicesupport_be_v1.service.entity;

import com.service.support.servicesupport_be_v1.exception.ResourceNotFoundException;
import com.service.support.servicesupport_be_v1.persistance.entity.SparePartsEntity;
import com.service.support.servicesupport_be_v1.persistance.repository.SparePartsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SparePartsService {

    private final SparePartsRepository repository;


    public List<SparePartsEntity> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "itemName"));
    }

    public List<SparePartsEntity> findAllByActiveTrue() {
        return repository.findAllByActiveTrue(Sort.by(Sort.Direction.ASC, "itemName"));
    }
    public SparePartsEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Spare part not found with id " + id));
    }

    public List<SparePartsEntity> findByName(String name) {
        return repository.findByItemNameContainingIgnoreCase(name);
    }

    public SparePartsEntity create(SparePartsEntity sparePart) {

        Optional<SparePartsEntity> existingOpt = repository.findByItemNumber(sparePart.getItemNumber());

        if (existingOpt.isPresent()) {
            SparePartsEntity existing = existingOpt.get();

            if (!existing.isActive()) {
                existing.setActive(true);
                return repository.save(existing);
            }
            throw new IllegalArgumentException("Spare part's item number is already in use: " + sparePart.getItemNumber());
        }
        return repository.save(sparePart);
    }

    public SparePartsEntity update(Long id, SparePartsEntity sparePart) {
        SparePartsEntity existing = findById(id);
        sparePart.setId(existing.getId());
        return repository.save(sparePart);
    }

    public void softDelete(Long id) {
        SparePartsEntity existing = findById(id);
        existing.setActive(false);
        repository.save(existing);
    }
}

