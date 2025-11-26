package com.service.support.servicesupport_be_v1.persistance.repository;

import com.service.support.servicesupport_be_v1.persistance.entity.OwnerCompanyEntity;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerCompanyRepository extends JpaRepository<OwnerCompanyEntity, Long> {
    OwnerCompanyEntity findByName(String name);

    List<OwnerCompanyEntity> findAllByActiveTrue(Sort name);
}