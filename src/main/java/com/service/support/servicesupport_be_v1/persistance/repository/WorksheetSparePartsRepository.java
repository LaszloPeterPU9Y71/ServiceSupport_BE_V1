package com.service.support.servicesupport_be_v1.persistance.repository;

import com.service.support.servicesupport_be_v1.persistance.entity.WorksheetSparePartsEntity;
import com.service.support.servicesupport_be_v1.persistance.entity.WorksheetSparePartsId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorksheetSparePartsRepository extends JpaRepository<WorksheetSparePartsEntity, WorksheetSparePartsId> {
    List<WorksheetSparePartsEntity> findByWorksheet_WorksheetId(Long worksheetId);
}
