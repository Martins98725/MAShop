package com.example.MAShop.DTOS.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOResponse {
    private UUID id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String zipcode;
    private String role;
}
