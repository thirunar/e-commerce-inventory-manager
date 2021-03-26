package com.example.ecommerce.inventorymanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    private Integer id;

    private Integer productId;

    private Integer quantity;

}
