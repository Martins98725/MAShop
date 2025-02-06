package com.example.MAShop.mappers;

import com.example.MAShop.DTOS.request.UserDTOPost;
import com.example.MAShop.DTOS.response.CartDTO;
import com.example.MAShop.DTOS.response.CartItemDTO;
import com.example.MAShop.DTOS.response.ProductDTOResponse;
import com.example.MAShop.DTOS.response.UserDTOResponseById;
import com.example.MAShop.models.Cart;
import com.example.MAShop.models.CartItems;
import com.example.MAShop.models.Product;
import com.example.MAShop.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTOPost userToUserDTOPost(User user);

    User userDTOPostToUser(UserDTOPost userDTOPost);

    @Mapping(source = "cart", target = "cart")
    UserDTOResponseById userToUserDtoResponseById(User user);

    @Mapping(source = "items", target = "items")
    CartDTO cartToCartDTO(Cart cart);

    @Mapping(target = "id", source = "product.id")
    CartItemDTO productToCartItemDTO(CartItems cartItems);

    ProductDTOResponse productToProductDTOResponse(Product product);


}
