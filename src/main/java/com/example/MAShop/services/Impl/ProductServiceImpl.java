package com.example.MAShop.services.Impl;

import com.example.MAShop.DTOS.request.ProductDTOPost;
import com.example.MAShop.DTOS.response.ProductDTOResponseAll;
import com.example.MAShop.DTOS.response.ProductUpdateDTO;
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
        List<Product> product = productRepository.findAll();

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
    public Optional<ProductUpdateDTO> update(ProductUpdateDTO productUpdateDTO, UUID id) {
        if (productRepository.existsById(id)) {
            Product product = ProductMapper.INSTANCE.productUpdateDTOToProduct(productUpdateDTO);
            product.setId(id);
            product = productRepository.save(product);
            return Optional.of(ProductMapper.INSTANCE.productToProductUpdateDTO(product));
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
