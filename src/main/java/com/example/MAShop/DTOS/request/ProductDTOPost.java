package com.example.MAShop.DTOS.request;

import com.example.MAShop.DTOS.response.UserDTOResponse;
import com.example.MAShop.models.Product;
import com.example.MAShop.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOPost {
    private UUID id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String image;
    private String barcode;
    private UUID userId;

    public ProductDTOPost ParseDTOToEntity(Product product) {
        ProductDTOPost productDTOPost = new ProductDTOPost();
        productDTOPost.setId(product.getId());
        productDTOPost.setName(product.getName());
        productDTOPost.setDescription(product.getDescription());
        productDTOPost.setPrice(product.getPrice());
        productDTOPost.setQuantity(product.getQuantity());
        productDTOPost.setImage(product.getImage());
        productDTOPost.setBarcode(product.getBarcode());

        productDTOPost.setUserId(product.getUser().getId());

        return productDTOPost;
    }

}