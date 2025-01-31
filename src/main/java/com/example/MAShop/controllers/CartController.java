package com.example.MAShop.controllers;

//import com.example.MAShop.DTOS.response.CartDTO;
import com.example.MAShop.DTOS.response.CartDTO;
import com.example.MAShop.models.Cart;
import com.example.MAShop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}/add")
    public ResponseEntity<CartDTO> addProductToCart(@PathVariable UUID userId, @RequestParam UUID productId, @RequestParam int quantity){
        CartDTO cart = cartService.addProductToCart(userId, productId, quantity);

        return ResponseEntity.ok(cart);
    }
}
