package com.example.MAShop.DTOS.response;

import com.example.MAShop.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOResponseAll {
    private UUID id;
    private String name;
    private String description;
    private double price;
    //private int quantity;
    private String image;
    //private String barcode;
    //private UserDTOResponse user;


    public ProductDTOResponseAll(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.image = product.getImage();
    }
}
