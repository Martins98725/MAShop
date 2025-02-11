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

    Optional<ProductDTOResponseAll> findById(UUID id);

    Optional<ProductUpdateDTO> update(ProductUpdateDTO product, UUID id);

    boolean deleteById(UUID id);
}
