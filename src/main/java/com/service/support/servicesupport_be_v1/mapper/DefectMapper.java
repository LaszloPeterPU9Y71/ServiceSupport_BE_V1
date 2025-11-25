package com.service.support.servicesupport_be_v1.mapper;

import com.service.support.servicesupport_be_v1.persistance.entity.DefectEntity;
import com.service.support.servicesupport_be_v1.web.model.Defect;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CommonMapper.class})
public interface DefectMapper {
    Defect toDto(DefectEntity entity);
    DefectEntity toEntity(Defect dto);
    List<Defect> toDtoList(List<DefectEntity> entities);
}
