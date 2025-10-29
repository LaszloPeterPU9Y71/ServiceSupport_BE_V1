package com.service.support.servicesupport_be_v1.persistance.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.service.support.servicesupport_be_v1.web.model.WorksheetStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "worksheet")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorksheetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worksheet_id", nullable = false)
    private Long worksheetId;

    @Column(name = "custom_id")
    private String customId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tool_id", nullable = false)
    private ToolEntity tool;


    @Column(name = "is_warranty", nullable = false)
    private boolean warranty;

    @Column(name = "has_warranty_card", nullable = false)
    private boolean hasWarrantyCard;

    @Column(name = "has_invoice_copy", nullable = false)
    private boolean hasInvoiceCopy;

    @Column(name = "has_registration_proof", nullable = false)
    private boolean hasRegistrationProof;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private WorksheetStatus status;

    @Column(name = "owner_description")
    private String ownerDescription;

    @OneToMany(mappedBy = "worksheet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<WorksheetNoteEntity> notes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "worksheet_defect",
            joinColumns = @JoinColumn(name = "worksheet_id"),
            inverseJoinColumns = @JoinColumn(name = "defect_id")
    )
    private List<DefectEntity> defects = new ArrayList<>();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assigned_user_id")
    private UserEntity assignedUser;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "worksheet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WorksheetSparePartsEntity> worksheetSpareParts = new ArrayList<>();

}