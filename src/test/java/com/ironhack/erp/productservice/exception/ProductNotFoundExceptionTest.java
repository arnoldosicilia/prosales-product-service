package com.ironhack.erp.productservice.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductNotFoundExceptionTest {

    @Test
    void assertThrows() {
        new ProductNotFoundException(null);
    }
}