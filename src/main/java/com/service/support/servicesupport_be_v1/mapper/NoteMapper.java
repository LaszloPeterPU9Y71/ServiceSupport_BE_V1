package com.service.support.servicesupport_be_v1.mapper;

import com.service.support.servicesupport_be_v1.persistance.entity.WorksheetNoteEntity;
import com.service.support.servicesupport_be_v1.web.model.WorksheetNote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, CommonMapper   .class})
public interface NoteMapper {

    @Mapping(source = "createdAt", target = "postedDate")
    @Mapping(source = "user.fullName", target = "userName")
    @Mapping(source = "user.id", target = "userId")
    WorksheetNote toDto(WorksheetNoteEntity entity);
}


