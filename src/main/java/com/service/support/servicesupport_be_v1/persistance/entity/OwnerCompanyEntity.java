package com.service.support.servicesupport_be_v1.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "owner_company")
@Getter
@Setter
public class OwnerCompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_company_id")
    private Long id;

    @Column(name = "owner_company_account_number", length = 255)
    private String accountNumber;

    @Column(name = "owner_company_name", length = 255)
    private String name;

    @Column(name = "owner_company_postal_code")
    private Integer postalCode;

    @Column(name = "owner_company_street", length = 255)
    private String street;

    @Column(name = "owner_company_tax_number", length = 255)
    private String taxNumber;

    @Column(name = "owner_company_town", length = 255)
    private String town;
}
