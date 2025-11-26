package com.service.support.servicesupport_be_v1.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "spare_parts")
@Getter
@Setter
public class SparePartsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spare_parts_id")
    private Long id;

    @Column(name = "spare_parts_netto_buying_price", nullable = false)
    private Integer nettoBuyingPrice;

    @Column(name = "spare_parts_netto_selling_price", nullable = false)
    private Integer nettoSellingPrice;

    @Column(name = "spare_parts_item_name", length = 255, nullable = false)
    private String itemName;

    @Column(name = "spare_parts_item_number", length = 255, nullable = false, unique = true)
    private String itemNumber;

    @Column(name = "spare_parts_status", nullable = false)
    private boolean active = true;


}
