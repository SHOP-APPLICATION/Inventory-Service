package com.inventory.stock.service.mappers;

import com.inventory.stock.service.dto.SortyRequest;
import com.inventory.stock.service.models.Sorty;

//@Mapper // mapstruct
public interface SortyMapper {
    Sorty dtoToModel (SortyRequest requestDTO);
}
