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
    private UUID id;
    private int quantity;
    private ProductDTOResponse product;


    /*public CartItemDTO(CartItems cartItems) {
        this.productId = cartItems.getProduct().getId();
        this.productName = cartItems.getProduct().getName();
        this.quantity = cartItems.getQuantity();
        this.price = cartItems.getProduct().getPrice();
    }*/
}
