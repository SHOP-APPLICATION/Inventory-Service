package com.inventory.stock.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockRequest {
    private UUID productId;
    private float quantity;
    private String unit;
    private String status;
}
