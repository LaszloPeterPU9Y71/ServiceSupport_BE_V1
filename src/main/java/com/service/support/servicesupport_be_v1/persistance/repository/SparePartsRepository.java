package com.service.support.servicesupport_be_v1.persistance.repository;

import com.service.support.servicesupport_be_v1.persistance.entity.SparePartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SparePartsRepository extends JpaRepository<SparePartsEntity, Long> {
    List<SparePartsEntity> findByItemNameContainingIgnoreCase(String name);
}
