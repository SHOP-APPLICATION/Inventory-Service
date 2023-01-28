package com.inventory.stock.service.services;

import com.inventory.stock.service.dto.StockRequest;
import com.inventory.stock.service.enums.Status;
import com.inventory.stock.service.models.Stock;

import java.util.List;
import java.util.UUID;

public interface StockService {

    Stock addStockOfProduct(StockRequest stockRequest);
    Stock editStockOfProduct(UUID id , StockRequest stockRequest);
    Stock getStockByProduct(String productId);
    List<Stock> getStocks();
    boolean changeStatus(UUID id, Status status);
}
