package com.service.support.servicesupport_be_v1.mapper;

import com.service.support.servicesupport_be_v1.persistance.entity.RoleEntity;
import com.service.support.servicesupport_be_v1.persistance.entity.UserEntity;
import com.service.support.servicesupport_be_v1.web.model.User;
import com.service.support.servicesupport_be_v1.web.model.UserSummary;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { RoleMapper.class , CommonMapper.class})
public interface UserMapper {


    User toDto(UserEntity entity);
    List<User> toDtoList(List<UserEntity> entities);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "fullName", source = "fullName")
    UserSummary toSummary(UserEntity entity);

    String toDto(RoleEntity entity);
}
