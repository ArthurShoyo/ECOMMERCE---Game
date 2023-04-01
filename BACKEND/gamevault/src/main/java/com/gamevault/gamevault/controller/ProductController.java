package com.gamevault.gamevault.controller;

import com.gamevault.gamevault.models.Products;
import com.gamevault.gamevault.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(200).body(productService.findallProducts());
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Products produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProducts(produto));
    }



}
