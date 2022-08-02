package com.shop.inventoryservice.service;

import com.shop.inventoryservice.dto.InventoryResponse;
import com.shop.inventoryservice.model.Inventory;
import com.shop.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCodes){
        return inventoryRepository.findBySkuCodeIn(skuCodes).stream()
                .map(this::mapInventoryResponseToDto)
                .toList();
    }

    public InventoryResponse mapInventoryResponseToDto(Inventory inventory){
        return InventoryResponse.builder()
                .skuCode(inventory.getSkuCode())
                .isInStock(inventory.getQuantity()>0)
                .build();
    }
}
