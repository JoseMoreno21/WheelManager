package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product getProduct(Long id);
    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> listAllProduct();
    Product edit(Product product,Long id);
    //List<Product>findByCategory(Category category);
    void deleteById(Long id);
}
