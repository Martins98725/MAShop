package com.example.MAShop.DTOS.response;

import lombok.*;
import java.util.UUID;


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

}
