package com.example.MAShop.services.Impl;

import com.example.MAShop.DTOS.request.ProductDTOPost;
import com.example.MAShop.DTOS.response.ProductDTOResponseAll;
import com.example.MAShop.models.Product;
import com.example.MAShop.models.User;
import com.example.MAShop.repositories.ProductRepository;
import com.example.MAShop.repositories.UserRepository;
import com.example.MAShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ProductDTOResponseAll> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDTOResponseAll> productDTOResponseAlls = new ArrayList<>();
        for (Product product : products) {
            productDTOResponseAlls.add(new ProductDTOResponseAll(product));
        }
        return productDTOResponseAlls;
    }

    @Override
    public Product save(ProductDTOPost productDTOPost) {

        Product product = new Product();
        //testar

        product.setName(productDTOPost.getName());
        product.setDescription(productDTOPost.getDescription());
        product.setPrice(productDTOPost.getPrice());
        product.setQuantity(productDTOPost.getQuantity());
        product.setImage(productDTOPost.getImage());
        product.setBarcode(productDTOPost.getBarcode());


        product = productRepository.save(product);


        return product;
    }

    @Override
    public Optional<Product> findById(UUID id) {

        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> update(Product product, UUID id) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            productRepository.save(product);
            return Optional.of(product);
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
