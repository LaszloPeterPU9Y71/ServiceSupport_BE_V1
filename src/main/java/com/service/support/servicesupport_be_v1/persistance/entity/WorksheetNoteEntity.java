package com.service.support.servicesupport_be_v1.persistance.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "worksheet_note")
@ToString(exclude = {"worksheet"})
@EqualsAndHashCode(exclude = {"worksheet"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorksheetNoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id", nullable = false)
    private Long noteId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worksheet_id", nullable = false)
    @JsonBackReference
    private WorksheetEntity worksheet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "note_text", nullable = false, length = 1000)
    private String noteText;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
