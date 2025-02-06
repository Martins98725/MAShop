package com.example.MAShop.mappers;

import com.example.MAShop.DTOS.response.CartDTO;
import com.example.MAShop.models.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    Cart cartDTOToCart(CartDTO cartDTO);

    CartDTO cartToCartDTO(Cart cart);
}
