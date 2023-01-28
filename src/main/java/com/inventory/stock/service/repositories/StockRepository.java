package com.inventory.stock.service.repositories;

import com.inventory.stock.service.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockRepository extends JpaRepository<Stock, UUID> {

    Stock findByProductId(UUID productIdd);
}
