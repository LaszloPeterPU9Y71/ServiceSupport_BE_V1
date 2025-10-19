package com.service.support.servicesupport_be_v1.service.entity;

import com.service.support.servicesupport_be_v1.exception.ResourceNotFoundException;
import com.service.support.servicesupport_be_v1.mapper.ToolMapper;
import com.service.support.servicesupport_be_v1.persistance.entity.ToolEntity;
import com.service.support.servicesupport_be_v1.persistance.repository.ToolRepository;
import com.service.support.servicesupport_be_v1.persistance.repository.UserRepository;
import com.service.support.servicesupport_be_v1.web.model.Tool;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ToolService {

    private final ToolRepository repository;
    private final ToolMapper mapper;

    public List<ToolEntity> findAll() {
        return repository.findAll();
    }

    public List<Tool> findAllDto() {
        return mapper.toDtoList(repository.findAll());
    }

    public ToolEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tool not found with id " + id));
    }

    public ToolEntity create(ToolEntity tool) {
        return repository.save(tool);
    }

    public ToolEntity update(Long id, Tool toolDto) {
        ToolEntity existing = findById(id);

        // egyszerű mezők frissítése
        existing.setToolId(toolDto.getToolId() != null ? toolDto.getToolId() : existing.getToolId());
        existing.setName(toolDto.getName());
        existing.setItemNumber(toolDto.getItemNumber());
        existing.setSerialNumber(toolDto.getSerialNumber());
        existing.setTypeNumber(toolDto.getTypeNumber());
        return repository.save(existing);
    }


    public void delete(Long id) {
        ToolEntity existing = findById(id);
        repository.delete(existing);
    }
}
