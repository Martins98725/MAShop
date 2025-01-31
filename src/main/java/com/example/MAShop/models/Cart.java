package com.example.MAShop.models;

import com.example.MAShop.DTOS.response.UserDTOResponseById;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_CART")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItems> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {

        CartItems item = items.stream()
                .filter(cartItem -> cartItem.getProduct().equals(product))
                .findFirst()
                .orElse(null);
        if (item == null) {
            CartItems newItem = new CartItems(this, product, quantity);
            items.add(newItem);
        } else {
            item.setQuantity(item.getQuantity() + quantity);
        }
    }

    public void removeProduct(Product product) {
        items.removeIf(item -> item.getProduct().equals(product));
    }

    public void clearCart() {
        items.clear();
    }

}
