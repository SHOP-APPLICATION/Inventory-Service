package com.inventory.stock.service.services.impl;

import com.inventory.stock.service.config.RestTemplateConfig;
import com.inventory.stock.service.dto.EntryRequest;
import com.inventory.stock.service.dto.EntryResponse;
import com.inventory.stock.service.enums.Status;
import com.inventory.stock.service.mappers.EntryMapper;
import com.inventory.stock.service.models.Entry;
import com.inventory.stock.service.repositories.EntryRepository;
import com.inventory.stock.service.repositories.StockRepository;
import com.inventory.stock.service.services.EntryService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private EntryMapper entryMapper;

    @Autowired
    private WebClient.Builder webClientBuilder;
    @Autowired
    private KeycloakRestTemplate restTemplate;
    @SneakyThrows
    @Override
    public EntryResponse addEntry(EntryRequest entryRequest) {
        log.info("here .......");
        Entry entry = entryMapper.dtoToModel(entryRequest);
        // check if the product exist
      /* boolean product =  webClientBuilder.build().get()
                .uri("http://product-service/api/products/check/" + entryRequest.getProduct())
                //.headers(h -> h.setBearerAuth())
                .retrieve()
                .bodyToMono(boolean.class)
                .block();
                */
        boolean product = restTemplate.getForObject("http://product-service/api/catalog/products/check/" + entryRequest.getProduct(), Boolean.class);
       if(!product) {
           // nead to change to ProductExecption capture in controller adivice
            throw new Exception("Product Not Exist with id : " + entryRequest.getProduct());
       }
       // check if the supplier exist

//        try {
//            boolean supplier =  webClientBuilder.build().get()
//                    .uri("http://product-service/api/suppliers/check/" + entryRequest.getSupplier())
//                    .retrieve()
//                    .bodyToMono(boolean.class)
//                    .block();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
       /* boolean supplier =  webClientBuilder.build().get()
                .uri("http://product-service/api/suppliers/check/" + entryRequest.getSupplier())
                .retrieve()
                .bodyToMono(boolean.class)
                .block();
        */
        if(false) {
        
            throw new Exception("Supplier Not Exist with id : "+entryRequest.getSupplier());
        }
        // save the entry
        entry.setStatus(Status.CREATED);
        // save in movement

        EntryResponse entryResponse = entryMapper.modelToDto(entryRepository.save(entry));
        return entryResponse;
    }

    @Override
    public EntryResponse editEntry(UUID id, EntryRequest entryRequest) {
        Entry entry = entryRepository.findById(id).orElse(null);
        if (entry != null && entry.getDeletedAt() == null) {
            entry.setExpireDate(entry.getExpireDate());
            entry.setFile(entry.getFile());
            entry.setLotNumber(entryRequest.getLotNumber());
            entry.setNumGoodCommand(entryRequest.getNumGoodCommand());
            entry.setPrice(entryRequest.getPrice());
            entry.setQuantity(entryRequest.getQuantity());
            entry.setSupplierId(UUID.fromString(entryRequest.getSupplier()));
            entry.setProductId(UUID.fromString(entryRequest.getProduct()));
            entry.setQteConsumed(entryRequest.getQteConsumed());
            EntryResponse entryResponse = entryMapper.modelToDto(entry);
            return entryResponse;
        }
        return null;
    }

    @Override
    public EntryResponse getEntry(UUID id) {
        return null;
    }

    @Override
    public List<EntryResponse> getEntries() {
        List<EntryResponse> entryResponses = new ArrayList<>();
        entryRepository.findAll().forEach(e -> {
            if(e.getDeletedAt() == null){
                entryResponses.add(entryMapper.modelToDto(e));
            }
        });
        return entryResponses;
    }

    @Override
    public List<EntryResponse> getEntriesByProduct(UUID productId) {
        return null;
    }

    @Override
    public boolean cancelEntry(UUID id) {
        Entry entry = entryRepository.findById(id).orElse(null);
        if (entry != null) {
            entry.setDeletedAt(LocalDateTime.now());
            entry.setStatus(Status.CANCELED);
            return true;
        }
        return false;
    }

}
