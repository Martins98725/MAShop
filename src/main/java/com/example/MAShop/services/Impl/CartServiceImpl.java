package com.example.MAShop.services.Impl;

//import com.example.MAShop.DTOS.response.CartDTO;
import com.example.MAShop.DTOS.response.CartDTO;
import com.example.MAShop.mappers.UserMapper;
import com.example.MAShop.models.Cart;
import com.example.MAShop.models.CartItems;
import com.example.MAShop.models.Product;
import com.example.MAShop.models.User;
import com.example.MAShop.repositories.CartRepository;
import com.example.MAShop.repositories.ProductRepository;
import com.example.MAShop.repositories.UserRepository;
import com.example.MAShop.services.CartService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        User user = getUserIfExist(userId);

        Product product = getProductIfExist(productId);

        Cart cart = user.getCart();
        cart = createCart(cart, user);

        CartItems cartItem = getCartItem(productId, cart);

        createCarItems(quantity, cartItem, cart, product);

        cart = cartRepository.save(cart);

        return UserMapper.INSTANCE.cartToCartDTO(cart);
    }

    private static void createCarItems(int quantity, CartItems cartItem, Cart cart, Product product) {
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity());
        } else {
            cartItem = new CartItems();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cart.getItems().add(cartItem);
        }
    }

    private static Cart createCart(Cart cart, User user) {
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart.setItems(new ArrayList<>());
            user.setCart(cart);
        }
        return cart;
    }

    private Product getProductIfExist(UUID productId) {
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    private User getUserIfExist(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user;
    }

    private static CartItems getCartItem(UUID productId, Cart cart) {
        return cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElse(null);
    }
}
