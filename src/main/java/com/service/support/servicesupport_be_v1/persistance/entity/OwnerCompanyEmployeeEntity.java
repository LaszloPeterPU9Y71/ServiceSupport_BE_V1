package com.service.support.servicesupport_be_v1.persistance.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "owner_company_employee")
@Getter
@Setter
public class OwnerCompanyEmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_company_employee_id")
    private Long id;

    @Column(name = "owner_company_employee_email", length = 255)
    private String email;

    @Column(name = "owner_company_employee_name", length = 255)
    private String name;

    @Column(name = "owner_company_employee_tel_num")
    private String telNum;

    @Column(name = "owner_company_employee_title", length = 255)
    private String title;

    // Kapcsolat a céghez
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_company_employee", referencedColumnName = "owner_company_id")
    private com.service.support.servicesupport_be_v1.persistance.entity.OwnerCompanyEntity ownerCompany;
}
