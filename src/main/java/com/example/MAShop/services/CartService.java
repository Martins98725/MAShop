package com.example.MAShop.services;

import com.example.MAShop.DTOS.response.CartDTO;
import com.example.MAShop.models.Cart;

import java.util.UUID;

public interface CartService {
     CartDTO addProductToCart(UUID userId, UUID productId, int quantity);

}
