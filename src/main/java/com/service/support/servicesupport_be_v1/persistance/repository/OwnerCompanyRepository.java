package com.service.support.servicesupport_be_v1.persistance.repository;

import com.service.support.servicesupport_be_v1.persistance.entity.OwnerCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerCompanyRepository extends JpaRepository<OwnerCompanyEntity, Long> {
}