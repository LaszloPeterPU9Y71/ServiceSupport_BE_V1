package com.service.support.servicesupport_be_v1.service.entity;


import com.service.support.servicesupport_be_v1.exception.ResourceNotFoundException;
import com.service.support.servicesupport_be_v1.persistance.entity.OwnerCompanyEntity;
import com.service.support.servicesupport_be_v1.persistance.repository.OwnerCompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerCompanyService {

    private final OwnerCompanyRepository repository;

    public OwnerCompanyService(OwnerCompanyRepository repository) {
        this.repository = repository;
    }

    public List<OwnerCompanyEntity> findAll() {
        return repository.findAll();
    }

    public OwnerCompanyEntity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nincs entity ilyen id-val:"+id));
    }

    public OwnerCompanyEntity save(OwnerCompanyEntity entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public OwnerCompanyEntity findByName(String ownerCompanyName) {
        return repository.findByName(ownerCompanyName);
    }

}