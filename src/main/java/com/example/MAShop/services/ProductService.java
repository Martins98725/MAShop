package com.example.MAShop.services;

import com.example.MAShop.DTOS.request.ProductDTOPost;
import com.example.MAShop.DTOS.response.ProductDTOResponseAll;
import com.example.MAShop.DTOS.response.ProductUpdateDTO;
import com.example.MAShop.models.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<ProductDTOResponseAll> findAll();

    ProductDTOPost save(ProductDTOPost productDTOPost);

    Optional<ProductUpdateDTO> findById(UUID id);

    Optional<ProductDTOResponseAll> update(ProductDTOResponseAll product, UUID id);

    boolean deleteById(UUID id);
}
