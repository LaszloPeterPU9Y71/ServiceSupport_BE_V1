package com.service.support.servicesupport_be_v1.persistance.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorksheetSparePartsId implements Serializable {
    private Long worksheetId;
    private Long sparePartsId;
}
