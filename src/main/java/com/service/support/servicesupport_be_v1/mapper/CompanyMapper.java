package com.service.support.servicesupport_be_v1.mapper;


import com.service.support.servicesupport_be_v1.persistance.entity.CompanyEntity;
import com.service.support.servicesupport_be_v1.web.model.Company;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring",uses = {CommonMapper.class})
public interface CompanyMapper {
    Company toDto(CompanyEntity entity);
    CompanyEntity toEntity(Company dto);
    List<Company> toDtoList(List<CompanyEntity> entities);
}
