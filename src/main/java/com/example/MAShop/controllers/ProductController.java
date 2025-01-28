package com.example.MAShop.controllers;

import com.example.MAShop.DTOS.request.ProductDTOPost;
import com.example.MAShop.DTOS.response.ProductDTOResponseAll;
import com.example.MAShop.models.Product;
import com.example.MAShop.models.User;
import com.example.MAShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTOPost product) {
        Product productSaved = productService.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTOResponseAll>> getAllProducts() {
        List<ProductDTOResponseAll> productDTOResponseAll = productService.findAll();
        return ResponseEntity.ok().body(productDTOResponseAll);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product>  getById(@PathVariable UUID id){
        return productService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Optional<Product> update(@RequestBody Product product, @PathVariable UUID id){

        return productService.update(product, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable UUID id){
        if(productService.deleteById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
