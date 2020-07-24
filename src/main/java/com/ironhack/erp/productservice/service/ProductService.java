package com.ironhack.erp.productservice.service;

import com.ironhack.erp.productservice.exception.ProductNotFoundException;
import com.ironhack.erp.productservice.model.entities.Product;
import com.ironhack.erp.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){ return productRepository.findAll();}
    public Product findById(Long id){ return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product with id: "+ id + " not found"));}
    public Product createProduct(Product product){ return productRepository.save(product);}
    public Product updateProduct(Product product, Long id) {
        Product target = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product with id: "+ id + " not found"));
        product.setId(target.getId());
        return productRepository.save(product);
    }
    public void deleteProduct(Long id){ productRepository.deleteById(id);}
    public void decreaseAmount(Long id, Integer amount) {
        Product target = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product with id: "+ id + " not found"));
        target.setStock(target.getStock()-amount);
        productRepository.save(target);
    }

}
