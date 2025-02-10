package com.example.MAShop.services.Impl;

import com.example.MAShop.DTOS.request.ProductDTOPost;
import com.example.MAShop.DTOS.response.ProductDTOResponseAll;
import com.example.MAShop.mappers.ProductMapper;
import com.example.MAShop.models.Product;
import com.example.MAShop.repositories.ProductRepository;
import com.example.MAShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTOResponseAll> findAll() {
        List<Product> product;

        product = productRepository.findAll();

        return ProductMapper.INSTANCE.productListToProductDTOResponseAllList(product);
    }

    @Override
    public ProductDTOPost save(ProductDTOPost productDTOPost) {
        Product product = ProductMapper.INSTANCE.productToProductDTOPost(productDTOPost);

        product = productRepository.save(product);


        return ProductMapper.INSTANCE.productToProductDTOPost(product);
    }

    @Override
    public Optional<ProductDTOResponseAll> findById(UUID id) {
        Product product = ProductMapper.INSTANCE.productDTOResponseToProduct(new ProductDTOResponseAll());

        product.setId(id);
        product = productRepository.findById(id).orElse(null);


        return Optional.of(ProductMapper.INSTANCE.productToProductDTOResponseAll(product));
    }

    @Override
    public Optional<ProductDTOResponseAll> update(ProductDTOResponseAll product, UUID id) {
        if (productRepository.existsById(id)) {
            Product product1 = ProductMapper.INSTANCE.productDTOResponseToProduct(product);
            product1.setId(id);
            product1 = productRepository.save(product1);
            return Optional.of(ProductMapper.INSTANCE.productToProductDTOResponseAll(product1));
        }

        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
