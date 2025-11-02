package com.service.support.servicesupport_be_v1.web.controller;

import com.service.support.servicesupport_be_v1.mapper.WorksheetMapper;
import com.service.support.servicesupport_be_v1.persistance.entity.WorksheetEntity;
import com.service.support.servicesupport_be_v1.service.entity.WorksheetService;
import com.service.support.servicesupport_be_v1.web.api.WorksheetApi;
import com.service.support.servicesupport_be_v1.web.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkSheetController implements WorksheetApi {

    private final WorksheetService worksheetService;
    private final WorksheetMapper worksheetMapper;


    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Worksheet> createWorksheet(WorksheetCreateRequest worksheetCreateRequest) {

        WorksheetEntity entity = worksheetService.createWorksheet(worksheetCreateRequest);
        return ResponseEntity.ok(worksheetMapper.toDto(entity));
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteWorksheet(Integer id) {
        worksheetService.deleteWorksheet(id.longValue());
        return ResponseEntity.noContent().build();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Worksheet>> getAllWorksheets() {
        List<WorksheetEntity> entities = worksheetService.getAllWorksheets();
        return ResponseEntity.ok(worksheetMapper.toDtoList(entities));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Worksheet> getWorksheetById(Integer id) {
        WorksheetEntity entity = worksheetService.findById(id.longValue());
        return ResponseEntity.ok(worksheetMapper.toDto(entity));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<WorksheetDetail> getWorksheetDetails(Integer id) {
        var result = worksheetService.getWorksheetDetails(id.longValue());
        return ResponseEntity.ok(result);
    }


    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<WorksheetListDto>> getWorksheetList() {
        return ResponseEntity.ok(worksheetService.getWorksheetList());
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> worksheetIdUpdatePut(Integer id, WorksheetUpdateRequest worksheetUpdateRequest){
        worksheetService.updateWorksheet(id, worksheetUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Worksheet> worksheetWorksheetIdAssignUserIdPost(Integer worksheetId, Integer userId) {
        WorksheetEntity updated = worksheetService.assignUser(worksheetId.longValue(), userId.longValue());
        return ResponseEntity.ok(worksheetMapper.toDto(updated));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Worksheet> worksheetWorksheetIdUnassignPost(Integer worksheetId) {
        WorksheetEntity updated = worksheetService.unassignUser(worksheetId.longValue());
        return ResponseEntity.ok(worksheetMapper.toDto(updated));
    }




    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> worksheetPost(WorksheetSaveRequest worksheetSaveRequest) {
        return null;
    }

}

