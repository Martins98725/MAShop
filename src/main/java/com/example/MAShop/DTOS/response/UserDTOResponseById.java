package com.example.MAShop.DTOS.response;

import com.example.MAShop.models.Cart;
import com.example.MAShop.models.CartItems;
import com.example.MAShop.models.Product;
import com.example.MAShop.models.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOResponseById {
    private UUID id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String zipcode;
    private String role;
    private CartDTO cart;

    /*public UserDTOResponseById(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.zipcode = user.getZipcode();
        this.role = user.getRole();

        Cart cartEntity = new Cart();
        cartEntity.setId(user.getCart().getId());
        cartEntity.getItems().forEach(item -> item.setCart(cartEntity));

        CartDTO dto = new CartDTO();

        dto.setId(cartEntity.getId());




    }*/

}
