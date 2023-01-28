package com.inventory.stock.service.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inventory.stock.service.enums.Status;
import com.inventory.stock.service.enums.Unit;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "sorties")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Sorty {

    @Id
    private UUID id;
    private UUID productId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entry_id")
    private Entry entry;
    private Integer qte;
    private UUID customerId;
    @Enumerated(EnumType.STRING)
    @Column(name="unit")
    private Unit unit;
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private Status status;
    private String raison;
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;
    @Column(name = "deleted_at", nullable = true)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime deletedAt;

}
