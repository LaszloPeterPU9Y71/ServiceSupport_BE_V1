package com.service.support.servicesupport_be_v1.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tool")
@Getter
@Setter
public class ToolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tool_id")
    private String toolId;

    @Column(name = "tool_item_number", length = 255, nullable = false)
    private String itemNumber;

    @Column(name = "tool_name", length = 255, nullable = false)
    private String name;

    @Column(name = "tool_serial_number", length = 255, unique = true)
    private String serialNumber;


    @Column(name = "tool_type_number", length = 255)
    private String typeNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tool_owner_id", nullable = false)
    private OwnerCompanyEmployeeEntity owner;

}
