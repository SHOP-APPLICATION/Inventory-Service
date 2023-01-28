package com.inventory.stock.service.services;

import com.inventory.stock.service.dto.EntryRequest;
import com.inventory.stock.service.dto.EntryResponse;

import java.util.List;
import java.util.UUID;

public interface EntryService {

    EntryResponse addEntry(EntryRequest entryRequest);
    EntryResponse editEntry(UUID id , EntryRequest entryRequest);
    EntryResponse getEntry(UUID id);
    List<EntryResponse> getEntries();
    List<EntryResponse> getEntriesByProduct(UUID productId);
    boolean cancelEntry(UUID id);
}
