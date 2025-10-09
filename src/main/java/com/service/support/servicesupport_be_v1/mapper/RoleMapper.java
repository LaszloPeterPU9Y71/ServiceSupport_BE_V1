package com.service.support.servicesupport_be_v1.mapper;

import com.service.support.servicesupport_be_v1.persistance.entity.RoleEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring",uses = {CommonMapper.class})
public interface RoleMapper {


    default String toDto(RoleEntity entity) {
        return entity != null ? entity.getName() : null;
    }
    List<String> toDtoList(List<RoleEntity> entities);
}