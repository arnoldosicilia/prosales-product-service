package com.ironhack.erp.productservice.controller.interfaces;

import com.ironhack.erp.productservice.model.entities.Product;

import java.util.List;

public interface ProductControllerInterface {
    public List<Product> findAll();
    public Product findById(Long id);
    public Product createProduct(Product product);
    public void deleteProduct(Long id);
    public void decreaseAmount(Long id, Integer amount);
}
