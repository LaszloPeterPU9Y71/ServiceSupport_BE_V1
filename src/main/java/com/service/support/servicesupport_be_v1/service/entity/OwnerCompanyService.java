package com.service.support.servicesupport_be_v1.service.entity;


import com.service.support.servicesupport_be_v1.exception.ResourceNotFoundException;
import com.service.support.servicesupport_be_v1.persistance.entity.OwnerCompanyEmployeeEntity;
import com.service.support.servicesupport_be_v1.persistance.entity.OwnerCompanyEntity;
import com.service.support.servicesupport_be_v1.persistance.repository.OwnerCompanyRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerCompanyService {

    private final OwnerCompanyRepository repository;

    public OwnerCompanyService(OwnerCompanyRepository repository) {
        this.repository = repository;
    }

    public List<OwnerCompanyEntity> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public List<OwnerCompanyEntity> findAllByActiveTrue() { return repository.findAllByActiveTrue(Sort.by(Sort.Direction.ASC, "name"));}

    public OwnerCompanyEntity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nincs entity ilyen id-val:"+id));
    }

    public OwnerCompanyEntity save(OwnerCompanyEntity ownerCompanyEntity) {
        Optional<OwnerCompanyEntity> existingOpt = repository.findByTaxNumber(ownerCompanyEntity.getTaxNumber());
        if (existingOpt.isPresent()) {
            OwnerCompanyEntity existing = existingOpt.get();

            if (!existing.isActive()) {
                existing.setActive(true);
                return repository.save(existing);
            }
            throw new IllegalArgumentException("Company tax number is already in use: " + ownerCompanyEntity.getTaxNumber());
        }
        return repository.save(ownerCompanyEntity);
    }

    public void softDelete(Long id) {
        OwnerCompanyEntity existing = findById(id);
        existing.setActive(false);
        repository.save(existing);
    }

    public OwnerCompanyEntity findByName(String ownerCompanyName) {
        return repository.findByName(ownerCompanyName);
    }

}