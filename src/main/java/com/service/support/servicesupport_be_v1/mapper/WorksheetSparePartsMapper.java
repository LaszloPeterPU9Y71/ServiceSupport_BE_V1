package com.service.support.servicesupport_be_v1.mapper;

import com.service.support.servicesupport_be_v1.persistance.entity.WorksheetSparePartsEntity;
import com.service.support.servicesupport_be_v1.web.model.SparePartUsage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {CommonMapper.class})
public interface WorksheetSparePartsMapper {

    @Mapping(target = "quantity", source = "quantity")
    SparePartUsage toDto(WorksheetSparePartsEntity entity);
}
