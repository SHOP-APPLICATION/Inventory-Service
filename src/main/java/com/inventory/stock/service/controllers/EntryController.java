package com.inventory.stock.service.controllers;

import com.inventory.stock.service.dto.EntryRequest;
import com.inventory.stock.service.dto.EntryResponse;
import com.inventory.stock.service.services.EntryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/stock/entries")
@Slf4j
public class EntryController {

    @Autowired
    private EntryService entryService;

    @PostMapping()
    public ResponseEntity<EntryResponse> save(@Valid @RequestBody EntryRequest requestDTO){
        log.info("controller Entries : start");
        return new ResponseEntity<>(entryService.addEntry(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntryResponse> edit(@Valid @RequestBody EntryRequest requestDTO, @PathVariable UUID id){
        EntryResponse entryResponse = entryService.editEntry(id, requestDTO);

        if (entryResponse != null) {
            return new ResponseEntity<>(entryResponse, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> cancled(@PathVariable UUID id) {
        boolean check =  entryService.cancelEntry(id);
        if(check){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public List<EntryResponse> getEntries() {
        return entryService.getEntries();
    }
}
