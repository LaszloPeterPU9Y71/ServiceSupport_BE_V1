package com.service.support.servicesupport_be_v1.persistance.repository;

import com.service.support.servicesupport_be_v1.persistance.entity.DefectEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DefectRepository extends JpaRepository<DefectEntity, Long> {

    List<DefectEntity> findAllByActiveTrue(Sort name);

    Optional<DefectEntity> findByName(String name);
}
