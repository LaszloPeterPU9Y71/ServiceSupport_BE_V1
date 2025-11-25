package com.service.support.servicesupport_be_v1.service.entity;

import com.service.support.servicesupport_be_v1.exception.ResourceNotFoundException;
import com.service.support.servicesupport_be_v1.persistance.entity.DefectEntity;
import com.service.support.servicesupport_be_v1.persistance.repository.DefectRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefectService {

    private final DefectRepository repository;

    public DefectService(DefectRepository repository) {
        this.repository = repository;
    }

    public List<DefectEntity> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public List<DefectEntity> findAllByActiveTrue() {
        return repository.findAllByActiveTrue(Sort.by(Sort.Direction.ASC, "name"));
    }

    public DefectEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Defect not found with id " + id));
    }

    public DefectEntity create(DefectEntity defect) {
        return repository.save(defect);
    }

    public DefectEntity update(Long id, DefectEntity defect) {
        DefectEntity existing = findById(id);
        existing.setName(defect.getName());
        return repository.save(existing);
    }

/*    public void delete(Long id) {
        DefectEntity existing = findById(id);
        repository.delete(existing);
    }*/

    public void softDelete(Long id) {
        DefectEntity existing = findById(id);
        existing.setActive(false);
        repository.save(existing);
    }
}
