package com.example.MAShop.DTOS.response;



import com.example.MAShop.models.CartItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
    private UUID productId;
    private String productName;
    private int quantity;
    private double price;


    public CartItemDTO(CartItems cartItems) {
        this.productId = cartItems.getProduct().getId();
        this.productName = cartItems.getProduct().getName();
        this.quantity = cartItems.getQuantity();
        this.price = cartItems.getProduct().getPrice();
    }
}
