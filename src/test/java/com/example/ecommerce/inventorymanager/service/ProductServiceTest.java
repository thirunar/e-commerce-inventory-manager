package com.example.ecommerce.inventorymanager.service;

import com.example.ecommerce.inventorymanager.entity.Product;
import com.example.ecommerce.inventorymanager.entity.ProductCategory;
import com.example.ecommerce.inventorymanager.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ProductService.class)
class ProductServiceTest {

    @Autowired
    private ProductService service;

    @MockBean
    private ProductRepository repository;

    @Test
    void shouldSaveTheProduct() {
        Product product = Product.builder().build();

        service.createProduct(product);

        verify(repository).save(product);
    }

    @Test
    void shouldGetTheProductById() throws JsonProcessingException {
        Product product = Product.builder().id(1).category(ProductCategory.builder().name("MOBILE").description("Mobile Phones").build()).name("iPhone").build();
        System.out.println(new ObjectMapper().writeValueAsString(product));
        when(repository.findById(any())).thenReturn(Optional.of(product));

        Product productFromRepo = service.getProduct(1);

        verify(repository).findById(1);
        assertThat(productFromRepo).isEqualTo(product);
    }
}