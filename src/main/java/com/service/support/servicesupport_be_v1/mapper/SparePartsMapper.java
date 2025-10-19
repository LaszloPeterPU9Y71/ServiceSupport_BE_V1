package com.service.support.servicesupport_be_v1.mapper;

import com.service.support.servicesupport_be_v1.persistance.entity.SparePartsEntity;
import com.service.support.servicesupport_be_v1.persistance.entity.WorksheetSparePartsEntity;
import com.service.support.servicesupport_be_v1.web.model.SparePart;
import com.service.support.servicesupport_be_v1.web.model.SparePartUsage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CommonMapper.class})
public interface SparePartsMapper {
    SparePart toDto(SparePartsEntity entity);

    SparePartsEntity toEntity(SparePart dto);

    List<SparePart> toDtoList(List<SparePartsEntity> entities);

    SparePartUsage toUsage(WorksheetSparePartsEntity sparepart);
}
