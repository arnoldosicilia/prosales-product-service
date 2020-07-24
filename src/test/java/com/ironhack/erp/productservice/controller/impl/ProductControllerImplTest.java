package com.ironhack.erp.productservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.erp.productservice.model.entities.Product;
import com.ironhack.erp.productservice.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
class ProductControllerImplTest {

    @Autowired
    ProductControllerImpl productController;

    @MockBean
    ProductRepository productRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    Product product;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        product = new Product("test", "provider", "ean", "img", new BigDecimal("100"), new BigDecimal("110"), 5);;


        when(productRepository.findAll()).thenReturn(Arrays.asList(product));
        when(productRepository.findById((long) 1)).thenReturn(java.util.Optional.ofNullable(product));
        when(productRepository.save(product)).thenReturn(product);
    }
    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/products")).andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/product/1")).andExpect(status().isOk());
    }

    @Test
    void createProduct() throws Exception {
        mockMvc.perform(post("/product")
                .content(objectMapper.writeValueAsString(product))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void updateProduct()throws Exception {
        mockMvc.perform(post("/product/1")
                .content(objectMapper.writeValueAsString(product))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/product/1")).andExpect(status().isNoContent());
    }

    @Test
    void decreaseAmount() throws Exception{
        mockMvc.perform(post("/products/1/5")).andExpect(status().isNoContent());
    }
}