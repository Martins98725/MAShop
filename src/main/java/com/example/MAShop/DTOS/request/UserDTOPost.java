package com.example.MAShop.DTOS.request;

import com.example.MAShop.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOPost {
    private UUID id;
    @NotBlank(message = "dhnasbdhabdhaavb")
    private String name;
    @NotBlank
    private String username;
    @NotBlank(message = "sjdbasjdhsabdah")
    private String password;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String address;
    @NotBlank
    private String zipcode;
    @NotBlank
    private String role;

}
