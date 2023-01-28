package com.inventory.stock.service.mappers;

import com.inventory.stock.service.dto.EntryRequest;
import com.inventory.stock.service.dto.EntryResponse;
import com.inventory.stock.service.models.Entry;

//@Mapper // mapstruct
public interface EntryMapper {
    Entry dtoToModel (EntryRequest requestDTO);
    EntryResponse modelToDto (Entry entry);
}
