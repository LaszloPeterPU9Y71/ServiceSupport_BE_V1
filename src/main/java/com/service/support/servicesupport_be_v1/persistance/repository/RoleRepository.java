package com.service.support.servicesupport_be_v1.persistance.repository;

import com.service.support.servicesupport_be_v1.persistance.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(String name);
}
