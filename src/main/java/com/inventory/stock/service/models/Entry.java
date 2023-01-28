package com.inventory.stock.service.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inventory.stock.service.enums.Status;
import com.inventory.stock.service.enums.Unit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "entries")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Entry {
    @Id
    private UUID id = UUID.randomUUID();
    private BigDecimal price;
    private Integer quantity;
    private Integer qteConsumed;
    @Enumerated(EnumType.STRING)
    @Column(name="unit")
    private Unit unit;
    private String expireDate;
    private String lotNumber;
    private String file;
    private String numGoodCommand;
    private UUID productId;
    private UUID supplierId;
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
