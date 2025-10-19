package com.service.support.servicesupport_be_v1.persistance.repository;

import com.service.support.servicesupport_be_v1.persistance.entity.DefectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefectRepository extends JpaRepository<DefectEntity, Long> {
}
