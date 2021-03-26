package com.example.ecommerce.inventorymanager.repository;

import com.example.ecommerce.inventorymanager.entity.Inventory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase
class InventoryRepositoryTest {

    @Autowired
    private InventoryRepository repository;

    @Test
    void shouldReturnInventoryBasedOnProductId() {
        Inventory inventory = repository.save(Inventory.builder().productId(1).inStock(10).build());

        Inventory actualInventory = repository.findByProductId(1);

        assertThat(actualInventory).isEqualTo(inventory);
    }
}