package com.service.support.servicesupport_be_v1.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "defect")
@Getter
@Setter
public class DefectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "defect_id")
    private Long id;

    @Column(name = "defect_name", length = 255, nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "defects")
    private List<WorksheetEntity> worksheets = new ArrayList<>();
}
