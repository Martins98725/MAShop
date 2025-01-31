package com.example.MAShop.repositories;

import com.example.MAShop.models.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, UUID> {
}
