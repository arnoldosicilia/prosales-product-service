package com.ironhack.erp.productservice.controller.impl;

import com.ironhack.erp.productservice.controller.interfaces.ProductControllerInterface;
import com.ironhack.erp.productservice.model.entities.Product;
import com.ironhack.erp.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProductControllerImpl implements ProductControllerInterface {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PostMapping("/product/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id ) {return productService.updateProduct(product, id);}

    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PostMapping("products/{id}/{amount}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void decreaseAmount(@PathVariable Long id, @PathVariable Integer amount) {
        productService.decreaseAmount(id, amount);
    }


}
