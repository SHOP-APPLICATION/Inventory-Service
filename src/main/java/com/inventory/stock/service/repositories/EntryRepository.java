package com.inventory.stock.service.repositories;


import com.inventory.stock.service.models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntryRepository extends JpaRepository<Entry, UUID> {
}
