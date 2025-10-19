package com.service.support.servicesupport_be_v1.mapper;

import com.service.support.servicesupport_be_v1.persistance.entity.ToolEntity;
import com.service.support.servicesupport_be_v1.web.model.Tool;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CommonMapper.class})
public interface ToolMapper {

    @Mapping(target = "ownerName", source = "owner.name")
    @Mapping(target = "ownerCompanyName", source = "owner.ownerCompany.name")
    Tool toDto(ToolEntity entity);

    @InheritInverseConfiguration
    ToolEntity toEntity(Tool dto);

    List<Tool> toDtoList(List<ToolEntity> entities);

}
