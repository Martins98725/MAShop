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
    private ProductDTOResponse product;
    private int quantity;

}
