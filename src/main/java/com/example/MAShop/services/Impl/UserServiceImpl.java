package com.example.MAShop.services.Impl;

import com.example.MAShop.DTOS.request.UserDTOPost;
import com.example.MAShop.DTOS.request.UserUpdateDTO;
import com.example.MAShop.DTOS.response.UserDTOResponse;
import com.example.MAShop.DTOS.response.UserDTOResponseById;
import com.example.MAShop.execeptions.BusinessException;
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

        return UserMapper.INSTANCE.usersToUserDTOResponses(users);
    }

    @Override
    public UserDTOPost save(UserDTOPost userDTOPost) throws BusinessException {
        User user = UserMapper.INSTANCE.userDTOPostToUser(userDTOPost);
        /*if (user.getName().isEmpty()){
            throw new BusinessException("this field not must be empty");
        }   */

        user = userRepository.save(user);

        return UserMapper.INSTANCE.userToUserDTOPost(user);
    }

    @Override
    public Optional<UserDTOResponseById> findById(UUID id) throws BusinessException {

        User user = userRepository.findById(id).orElseThrow(() -> new BusinessException("User doesn't exist"));

        return Optional.of(UserMapper.INSTANCE.userToUserDtoResponseById(user));
    }

    @Override
    public Optional<UserUpdateDTO> update(UserUpdateDTO userUpdateDTO, UUID id) throws BusinessException {
        if (userRepository.existsById(id)){
            User user = UserMapper.INSTANCE.updateUserDTOToUser(userUpdateDTO);
            user.setId(id);
            user = userRepository.save(user);

            return Optional.of(UserMapper.INSTANCE.userToUserUpdateDTO(user));
        }
        else {
            throw new BusinessException("User doesn't exist");
        }
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
