package com.example.ecommerce.inventorymanager.events;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RunningOutOfStockEvent {

    private Integer productId;

    private Integer currentStock;
}
