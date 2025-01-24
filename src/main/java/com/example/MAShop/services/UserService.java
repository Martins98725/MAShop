package com.example.MAShop.services;

import com.example.MAShop.DTOS.request.UserDTOPost;
import com.example.MAShop.DTOS.response.UserDTOResponseAll;
import com.example.MAShop.models.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<UserDTOResponseAll> findAll();

    UserDTOPost save(UserDTOPost user);

    Optional<User> findById(UUID id);

    Optional<User> update(User user, UUID id);

    boolean deleteById(UUID id);
}
