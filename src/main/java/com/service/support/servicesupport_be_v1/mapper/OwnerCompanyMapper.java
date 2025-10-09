package com.service.support.servicesupport_be_v1.mapper;

import com.service.support.servicesupport_be_v1.persistance.entity.OwnerCompanyEntity;
import com.service.support.servicesupport_be_v1.web.model.OwnerCompany;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CommonMapper.class})
public interface OwnerCompanyMapper {

    OwnerCompany toDto(OwnerCompanyEntity entity);

    OwnerCompanyEntity toEntity(OwnerCompany dto);

    List<OwnerCompany> toDtoList(List<OwnerCompanyEntity> entities);
}
