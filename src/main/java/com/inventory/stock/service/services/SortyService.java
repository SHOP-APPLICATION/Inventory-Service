package com.inventory.stock.service.services;

import com.inventory.stock.service.dto.SortyRequest;
import com.inventory.stock.service.models.Sorty;

import java.util.List;
import java.util.UUID;

public interface SortyService {

    Sorty addSorty(SortyRequest sortyRequest);
    List<Sorty> getSorties();
    Sorty getSorty(UUID id);
    boolean cancelSorty(UUID id);
}
