package com.example.MAShop.services.Impl;

import com.example.MAShop.DTOS.request.UserDTOPost;
import com.example.MAShop.DTOS.response.UserDTOResponse;
import com.example.MAShop.DTOS.response.UserDTOResponseById;
import com.example.MAShop.mappers.UserMapper;
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
        List<UserDTOResponse> userDTOResponsAlls = new ArrayList<>();
        for (User user : users) {
            userDTOResponsAlls.add(new UserDTOResponse(user));
        }
        return userDTOResponsAlls;
    }

    @Override
    public UserDTOPost save(UserDTOPost userDTOPost) {
        User user = UserMapper.INSTANCE.userDTOPostToUser(userDTOPost);

        user = userRepository.save(user);

        return UserMapper.INSTANCE.userToUserDTOPost(user);
    }

    @Override
    public Optional<UserDTOResponseById> findById(UUID id) {

        User user = userRepository.findById(id).orElse(null);

        return Optional.of(UserMapper.INSTANCE.userToUserDtoResponseById(user));
    }

    @Override
    public Optional<User> update(User user, UUID id) {
        if (userRepository.existsById(id)){
            user.setId(id);
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
