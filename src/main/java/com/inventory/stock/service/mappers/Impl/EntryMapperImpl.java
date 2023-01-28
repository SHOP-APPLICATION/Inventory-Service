package com.inventory.stock.service.mappers.Impl;

import com.inventory.stock.service.dto.EntryRequest;
import com.inventory.stock.service.dto.EntryResponse;
import com.inventory.stock.service.mappers.EntryMapper;
import com.inventory.stock.service.models.Entry;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EntryMapperImpl implements EntryMapper {
    @Override
    public Entry dtoToModel(EntryRequest requestDTO) {
        return Entry
                .builder()
                .id(UUID.randomUUID())
                .price(requestDTO.getPrice())
                .quantity(requestDTO.getQuantity())
                .expireDate(requestDTO.getExpireDate())
                .lotNumber(requestDTO.getLotNumber())
                .numGoodCommand(requestDTO.getNumGoodCommand())
                .raison(requestDTO.getRaison())
                .productId(UUID.fromString(requestDTO.getProduct()))
                .supplierId(UUID.fromString(requestDTO.getSupplier()))
                .unit(requestDTO.getUnit())
                .build();
    }

    @Override
    public EntryResponse modelToDto(Entry entry) {
        return EntryResponse
                .builder()
                .expireDate(entry.getExpireDate())
                .file(entry.getFile())
                .id(entry.getId())
                .lotNumber(entry.getLotNumber())
                .numGoodCommand(entry.getNumGoodCommand())
                .price(entry.getPrice())
                .productId(entry.getProductId().toString())
                .quantity(entry.getQuantity())
                .raison(entry.getRaison())
                .status(entry.getStatus())
                .supplierId(entry.getSupplierId().toString())
                .unit(entry.getUnit())
                .build();
    }
}
