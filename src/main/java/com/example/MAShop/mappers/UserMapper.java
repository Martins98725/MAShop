package com.example.MAShop.mappers;

import com.example.MAShop.DTOS.request.UserDTOPost;
import com.example.MAShop.DTOS.request.UserUpdateDTO;
import com.example.MAShop.DTOS.response.*;
import com.example.MAShop.models.Cart;
import com.example.MAShop.models.CartItems;
import com.example.MAShop.models.Product;
import com.example.MAShop.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTOPost userToUserDTOPost(User user);

    User userDTOPostToUser(UserDTOPost userDTOPost);

    @Mapping(source = "cart", target = "cart")
    UserDTOResponseById userToUserDtoResponseById(User user);

    @Mapping(target = "cartId", source = "id")
    @Mapping(source = "items", target = "items")
    CartDTO cartToCartDTO(Cart cart);

    CartItemDTO productToCartItemDTO(CartItems cartItems);

    ProductDTOResponse productToProductDTOResponse(Product product);

    List<UserDTOResponse> usersToUserDTOResponses(List<User> users);

    UserUpdateDTO userToUserUpdateDTO(User user);

    User updateUserDTOToUser(UserUpdateDTO userUpdateDTO);


}
