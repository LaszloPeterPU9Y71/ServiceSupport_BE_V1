package com.service.support.servicesupport_be_v1.persistance.repository;

import com.service.support.servicesupport_be_v1.persistance.entity.WorksheetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorksheetRepository extends JpaRepository<WorksheetEntity, Long> {

    Optional<WorksheetEntity> findWithDetailsByWorksheetId(Long worksheetId);
    long countByCustomIdStartingWith(String prefix);
}