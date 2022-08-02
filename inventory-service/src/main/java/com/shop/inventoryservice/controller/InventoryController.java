package com.shop.inventoryservice.controller;

import com.shop.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventories")
@RequiredArgsConstructor
class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/${sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isInStock(@PathVariable("sku-code") String skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
