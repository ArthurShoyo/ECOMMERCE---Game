package com.gamevault.gamevault.service;

import com.gamevault.gamevault.models.Products;
import com.gamevault.gamevault.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Products> findallProducts() {
        return productRepository.findAll();
    }

    public Products saveProducts(Products products) {
        return productRepository.save(products);
    }

}
