package com.inventory.stock.service.dto;

import com.inventory.stock.service.enums.Unit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SortyResponse {
    private UUID id;
    private Integer quantity;
    private Unit unit;
    private String productId;
}
