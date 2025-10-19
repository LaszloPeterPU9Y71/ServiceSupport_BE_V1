package com.service.support.servicesupport_be_v1.mapper;

import com.service.support.servicesupport_be_v1.persistance.entity.WorksheetEntity;
import com.service.support.servicesupport_be_v1.web.model.Worksheet;
import com.service.support.servicesupport_be_v1.web.model.WorksheetCreateRequest;
import com.service.support.servicesupport_be_v1.web.model.WorksheetDetail;
import com.service.support.servicesupport_be_v1.web.model.WorksheetListDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        ToolMapper.class,
        DefectMapper.class,
        NoteMapper.class,
        WorksheetSparePartsMapper.class,
        UserMapper.class,
        CommonMapper.class,
})
public interface WorksheetMapper {

    WorksheetEntity toEntity(WorksheetCreateRequest dto);

    Worksheet toDto(WorksheetEntity entity);

    List<Worksheet> toDtoList(List<WorksheetEntity> entities);

    List<WorksheetEntity> toEntityList(List<Worksheet> dtos);


    @Mapping(source = "worksheetId", target = "worksheetId")
    @Mapping(source = "tool.id", target = "toolId")
    @Mapping(source = "tool.itemNumber", target = "toolItemNumber")
    @Mapping(source = "tool.serialNumber", target = "toolSerialNumber")
    @Mapping(source = "tool.owner.name", target = "ownerCompanyName")
    @Mapping(source = "tool.owner.ownerCompany.name", target = "ownerCompanyEmployeeName")
    @Mapping(source = "assignedUser.fullName", target = "assignedUserFullName")
    @Mapping(source = "status", target = "status")
    WorksheetListDto toListDto(WorksheetEntity entity);


    @Mapping(target = "isWarranty", source = "warranty")
    WorksheetDetail toDetailDto(WorksheetEntity entity);


}
