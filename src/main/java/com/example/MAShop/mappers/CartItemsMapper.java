package com.example.MAShop.mappers;

import com.example.MAShop.DTOS.response.CartItemDTO;
import com.example.MAShop.models.CartItems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartItemsMapper {
    CartItemsMapper INSTANCE = Mappers.getMapper(CartItemsMapper.class);


    CartItems cartItemsToCartItemsDTO(CartItemDTO cartItemDTO);

    CartItemDTO cartItemsToCartItemDTO(CartItems cartItems);
}
