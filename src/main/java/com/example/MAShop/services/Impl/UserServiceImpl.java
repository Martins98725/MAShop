package com.example.MAShop.services.Impl;

import com.example.MAShop.models.User;
import com.example.MAShop.repositories.UserRepository;
import com.example.MAShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        //vai vir tudo do dto
       /* User savedUser = userRepository.save(user);*/

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
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
