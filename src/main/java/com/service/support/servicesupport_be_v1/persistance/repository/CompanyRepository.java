package com.service.support.servicesupport_be_v1.persistance.repository;



import com.service.support.servicesupport_be_v1.persistance.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    List<CompanyEntity> findByNameContainingIgnoreCase(String name);
}
