package com.example.MAShop.services.Impl;

import com.example.MAShop.DTOS.request.UserDTOPost;
import com.example.MAShop.DTOS.response.UserDTOResponse;
import com.example.MAShop.models.User;
import com.example.MAShop.repositories.UserRepository;
import com.example.MAShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<UserDTOResponse> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTOResponse> userDTOResponses = new ArrayList<>();
        for (User user : users) {
            userDTOResponses.add(new UserDTOResponse(user));
        }
        return userDTOResponses;
    }

    @Override
    public User save(UserDTOPost userDTOPost) {
        User newUser = new User();

        newUser.setName(userDTOPost.getName());
        newUser.setEmail(userDTOPost.getEmail());
        newUser.setPassword(userDTOPost.getPassword());
        newUser.setRole(userDTOPost.getRole());
        newUser.setAddress(userDTOPost.getAddress());
        newUser.setPhone(userDTOPost.getPhone());
        newUser.setUsername(userDTOPost.getUsername());
        newUser.setZipcode(userDTOPost.getZipcode());
        newUser = userRepository.save(newUser);

        return newUser;
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> update(User user, UUID id) {
        if (userRepository.existsById(id)){
            user = userRepository.save(user);

            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
