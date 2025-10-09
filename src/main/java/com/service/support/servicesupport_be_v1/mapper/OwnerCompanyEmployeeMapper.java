package com.service.support.servicesupport_be_v1.mapper;

import com.service.support.servicesupport_be_v1.persistance.entity.OwnerCompanyEmployeeEntity;
import com.service.support.servicesupport_be_v1.web.model.OwnerCompanyEmployee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CommonMapper.class})
public interface OwnerCompanyEmployeeMapper {

    @Mapping(target = "ownerCompanyId", source = "ownerCompany.id")
    OwnerCompanyEmployee toDto(OwnerCompanyEmployeeEntity entity);

    OwnerCompanyEmployeeEntity toEntity(OwnerCompanyEmployee dto);

    List<OwnerCompanyEmployee> toDtoList(List<OwnerCompanyEmployeeEntity> entities);
}
