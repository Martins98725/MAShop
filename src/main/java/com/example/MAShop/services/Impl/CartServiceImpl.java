package com.example.MAShop.services.Impl;

//import com.example.MAShop.DTOS.response.CartDTO;
import com.example.MAShop.DTOS.response.CartDTO;
import com.example.MAShop.models.Cart;
import com.example.MAShop.models.CartItems;
import com.example.MAShop.models.Product;
import com.example.MAShop.models.User;
import com.example.MAShop.repositories.CartRepository;
import com.example.MAShop.repositories.ProductRepository;
import com.example.MAShop.repositories.UserRepository;
import com.example.MAShop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public CartDTO addProductToCart(UUID userId, UUID productId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = cartRepository.findByUserId(userId).orElseGet(() ->
        {
            Cart newCart = new Cart();
            newCart.setUser(user);
            return cartRepository.save(newCart);
        });

        CartItems cartItem = cart.getItems().stream().filter(item -> item.getProduct().getId().equals(productId)).findFirst().orElse(null);

        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity());
        } else {
            cartItem = new CartItems();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cart.getItems().add(cartItem);
        }
        cart.addProduct(product, quantity);

        cart = cartRepository.save(cart);

        return new CartDTO(cart);
    }
}
