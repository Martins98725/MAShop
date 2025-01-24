package com.example.MAShop.DTOS.request;

import com.example.MAShop.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOPost {
    private UUID id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String zipcode;
    private String role;

    public UserDTOPost ParseDTOToEntity(User user) {
        UserDTOPost userDTOPost = new UserDTOPost();
        userDTOPost.setId(user.getId());
        userDTOPost.setName(user.getName());
        userDTOPost.setUsername(user.getUsername());
        userDTOPost.setPassword(user.getPassword());
        userDTOPost.setEmail(user.getEmail());
        userDTOPost.setPhone(user.getPhone());
        userDTOPost.setAddress(user.getAddress());
        userDTOPost.setZipcode(user.getZipcode());
        userDTOPost.setRole(user.getRole());
        return userDTOPost;
    }
}
