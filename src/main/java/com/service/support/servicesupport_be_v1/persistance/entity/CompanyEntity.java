package com.service.support.servicesupport_be_v1.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(name = "company_name", nullable = false, length = 255)
    private String name;

    @Column(name = "company_postal_code")
    private Integer postalCode;

    @Column(name = "company_status", nullable = false)
    private Boolean status;

    @Column(name = "company_street", length = 255)
    private String street;

    @Column(name = "company_tax_number", length = 255)
    private String taxNumber;

    @Column(name = "company_town", length = 255)
    private String town;
}
