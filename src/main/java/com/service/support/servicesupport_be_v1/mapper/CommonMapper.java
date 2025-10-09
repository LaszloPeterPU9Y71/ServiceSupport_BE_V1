package com.service.support.servicesupport_be_v1.mapper;

import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Mapper(componentModel = "spring")
public interface CommonMapper {

    default <T> List<T> mapList(Collection<T> source) {
        return source == null ? new ArrayList<>() : new ArrayList<>(source);
    }
    default <T> Set<T> mapSet(Collection<T> source) {
        return source == null ? new HashSet<>() : new HashSet<>(source);
    }


    default OffsetDateTime map(LocalDateTime value) {
        return value != null ? value.atOffset(ZoneOffset.UTC) : null;
    }

    default LocalDateTime map(OffsetDateTime value) {
        return value != null ? value.toLocalDateTime() : null;
    }

}
