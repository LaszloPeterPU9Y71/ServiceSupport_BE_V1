package com.service.support.servicesupport_be_v1.persistance.repository;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.service.support.servicesupport_be_v1.persistance.entity.OwnerCompanyEmployeeEntity;

import java.util.List;


public interface OwnerCompanyEmployeeRepository extends JpaRepository<OwnerCompanyEmployeeEntity, Long> {
    List<OwnerCompanyEmployeeEntity> findAllByActiveTrue(Sort name);
}
