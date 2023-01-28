package com.inventory.stock.service.services.impl;


import com.inventory.stock.service.dto.StockRequest;
import com.inventory.stock.service.enums.Status;
import com.inventory.stock.service.enums.Unit;
import com.inventory.stock.service.models.Stock;
import com.inventory.stock.service.repositories.StockRepository;
import com.inventory.stock.service.services.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock addStockOfProduct(StockRequest stockRequest) {
        Stock stock = new Stock();
        stock.setId(UUID.randomUUID());
        stock.setProductId(stockRequest.getProductId());
        stock.setQuantity(stockRequest.getQuantity());
        stock.setStatus(Status.valueOf(stockRequest.getStatus()));
        stock.setUnit(Unit.valueOf(stockRequest.getUnit()));
        return  stockRepository.save(stock);
    }

    @Override
    public Stock editStockOfProduct(UUID id, StockRequest stockRequest) {
        Stock stock = stockRepository.findById(id).orElse(null);
        if(stock == null) {
            return null;
        }
        stock.setId(UUID.randomUUID());
        stock.setProductId(stockRequest.getProductId());
        stock.setQuantity(stockRequest.getQuantity());
        stock.setStatus(Status.valueOf(stockRequest.getStatus()));
        stock.setUnit(Unit.valueOf(stockRequest.getUnit()));
        return stock;
    }

    @Override
    public Stock getStockByProduct(String productId) {
        return null;
    }

    @Override
    public List<Stock> getStocks() {
        return null;
    }

    @Override
    public boolean changeStatus(UUID id, Status status) {
        return false;
    }
}
