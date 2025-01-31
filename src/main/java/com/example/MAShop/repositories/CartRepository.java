package com.example.MAShop.repositories;

import com.example.MAShop.models.Cart;
import com.example.MAShop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {
    Optional<Cart> findByUserId(UUID userId);

    Cart findByUser(User user);
}
