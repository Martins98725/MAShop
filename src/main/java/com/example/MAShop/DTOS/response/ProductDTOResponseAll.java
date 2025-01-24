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
    private int quantity;
    private String image;
    private String barcode;
    private UserDTOResponse user;


    public ProductDTOResponseAll(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.image = product.getImage();
        this.barcode = product.getBarcode();

        UserDTOResponse user = new UserDTOResponse();
        user.setId(product.getUser().getId());
        user.setName(product.getUser().getName());
        user.setEmail(product.getUser().getEmail());
        user.setZipcode(product.getUser().getZipcode());
        user.setAddress(product.getUser().getAddress());
        this.user = user;
    }
}
