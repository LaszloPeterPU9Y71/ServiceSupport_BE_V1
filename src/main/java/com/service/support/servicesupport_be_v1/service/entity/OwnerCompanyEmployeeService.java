package com.service.support.servicesupport_be_v1.service.entity;


import com.service.support.servicesupport_be_v1.exception.ResourceNotFoundException;
import com.service.support.servicesupport_be_v1.mapper.OwnerCompanyEmployeeMapper;
import com.service.support.servicesupport_be_v1.persistance.entity.OwnerCompanyEmployeeEntity;
import com.service.support.servicesupport_be_v1.persistance.repository.OwnerCompanyEmployeeRepository;
import com.service.support.servicesupport_be_v1.persistance.repository.OwnerCompanyRepository;
import com.service.support.servicesupport_be_v1.web.model.OwnerCompanyEmployee;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerCompanyEmployeeService {


    private final OwnerCompanyEmployeeRepository repository;
    private final OwnerCompanyRepository ownerCompanyRepository;
    private final OwnerCompanyService ownerCompanyService;
    private final OwnerCompanyEmployeeMapper mapper;


    public OwnerCompanyEmployeeService(OwnerCompanyEmployeeRepository repository, OwnerCompanyRepository ownerCompanyRepository, OwnerCompanyService ownerCompanyService, OwnerCompanyEmployeeMapper mapper) {
        this.repository = repository;
        this.ownerCompanyRepository = ownerCompanyRepository;
        this.ownerCompanyService = ownerCompanyService;
        this.mapper = mapper;
    }

    public List<OwnerCompanyEmployeeEntity> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
    public List<OwnerCompanyEmployeeEntity> findAllByActiveTrue() {
        return repository.findAllByActiveTrue(Sort.by(Sort.Direction.ASC, "name"));
    }


    public OwnerCompanyEmployeeEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }

    public OwnerCompanyEmployeeEntity create(OwnerCompanyEmployee dto) {
        OwnerCompanyEmployeeEntity result = mapper.toEntity(dto);
        result.setOwnerCompany(ownerCompanyService.findByName(dto.getOwnerCompanyName()));
        return repository.save(result);
    }

    public OwnerCompanyEmployeeEntity update(Long id, OwnerCompanyEmployee updated) {
        OwnerCompanyEmployeeEntity existing = findById(id);

        if (updated.getName() != null) existing.setName(updated.getName());
        if (updated.getEmail() != null) existing.setEmail(updated.getEmail());
        if (updated.getTelNum() != null) existing.setTelNum(updated.getTelNum());
        if (updated.getTitle() != null) existing.setTitle(updated.getTitle());
        if (updated.getOwnerCompanyName() != null)
            existing.setOwnerCompany(ownerCompanyService.findByName(updated.getOwnerCompanyName()));
        else
            existing.setOwnerCompany(null);

        return repository.save(existing);
    }


    public void SoftDelete(Long id) {
        OwnerCompanyEmployeeEntity existing = findById(id);
        existing.setActive(false);
        repository.save(existing);
    }
}
