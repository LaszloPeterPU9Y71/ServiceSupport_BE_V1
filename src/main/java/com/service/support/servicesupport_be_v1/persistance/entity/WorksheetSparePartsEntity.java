package com.service.support.servicesupport_be_v1.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "worksheet_spareparts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorksheetSparePartsEntity {

    @EmbeddedId
    private WorksheetSparePartsId id = new WorksheetSparePartsId();

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("sparePartsId")
    @JoinColumn(name = "spare_parts_id")
    private SparePartsEntity sparePart;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("worksheetId")
    @JoinColumn(name = "worksheet_id")
    private WorksheetEntity worksheet;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}
