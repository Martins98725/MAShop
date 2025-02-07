package com.example.MAShop.DTOS.response;

import com.example.MAShop.models.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private UUID id;
    private List<CartItemDTO> items;
}
