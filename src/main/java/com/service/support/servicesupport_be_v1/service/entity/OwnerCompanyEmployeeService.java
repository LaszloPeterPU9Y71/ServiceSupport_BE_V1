package com.service.support.servicesupport_be_v1.service.entity;


import com.service.support.servicesupport_be_v1.exception.ResourceNotFoundException;
import com.service.support.servicesupport_be_v1.persistance.entity.OwnerCompanyEmployeeEntity;
import com.service.support.servicesupport_be_v1.persistance.repository.OwnerCompanyEmployeeRepository;
import com.service.support.servicesupport_be_v1.persistance.repository.OwnerCompanyRepository;
import com.service.support.servicesupport_be_v1.web.model.OwnerCompanyEmployee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerCompanyEmployeeService {

    private final OwnerCompanyEmployeeRepository repository;
    private final OwnerCompanyRepository ownerCompanyRepository;
    private final OwnerCompanyService ownerCompanyService;

    public OwnerCompanyEmployeeService(OwnerCompanyEmployeeRepository repository, OwnerCompanyRepository ownerCompanyRepository, OwnerCompanyService ownerCompanyService) {
        this.repository = repository;
        this.ownerCompanyRepository = ownerCompanyRepository;
        this.ownerCompanyService = ownerCompanyService;
    }

    public List<OwnerCompanyEmployeeEntity> findAll() {
        return repository.findAll();
    }

    public OwnerCompanyEmployeeEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }

    public OwnerCompanyEmployeeEntity create(OwnerCompanyEmployeeEntity entity) {
        return repository.save(entity);
    }

    public OwnerCompanyEmployeeEntity update(Long id, OwnerCompanyEmployee updated) {
        OwnerCompanyEmployeeEntity existing = findById(id);

        if (updated.getName() != null) existing.setName(updated.getName());
        if (updated.getEmail() != null) existing.setEmail(updated.getEmail());
        if (updated.getTelNum() != null) existing.setTelNum(updated.getTelNum());
        if (updated.getTitle() != null) existing.setTitle(updated.getTitle());
        if (updated.getOwnerCompanyId() != null)
            existing.setOwnerCompany(ownerCompanyService.findById(updated.getOwnerCompanyId().longValue()));
        else
            existing.setOwnerCompany(null);

        return repository.save(existing);
    }


    public void delete(Long id) {
        OwnerCompanyEmployeeEntity existing = findById(id);
        repository.delete(existing);
    }
}
