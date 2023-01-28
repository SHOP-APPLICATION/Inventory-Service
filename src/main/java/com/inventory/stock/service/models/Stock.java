package com.inventory.stock.service.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inventory.stock.service.enums.Status;
import com.inventory.stock.service.enums.Unit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "stocks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock {

    @Id
    private UUID id = UUID.randomUUID();
    private UUID productId;
    private float quantity;
    @Enumerated(EnumType.STRING)
    @Column(name="unit")
    private Unit unit;
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private Status status;
    @Column(nullable = false, updatable = true)
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;
    @Column(nullable = false, updatable = true)
    @UpdateTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at", nullable = true)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime deletedAt;
}
