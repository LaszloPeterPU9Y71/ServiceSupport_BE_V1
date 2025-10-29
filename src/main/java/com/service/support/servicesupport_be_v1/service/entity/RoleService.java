package com.service.support.servicesupport_be_v1.service.entity;

import com.service.support.servicesupport_be_v1.persistance.entity.RoleEntity;
import com.service.support.servicesupport_be_v1.persistance.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<RoleEntity> findAll() {
        return roleRepository.findAll();
    }

    public RoleEntity findByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> new RuntimeException("Role with name " + name + " not found"));
    }
}
