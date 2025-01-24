package com.example.MAShop.controllers;

import com.example.MAShop.DTOS.request.UserDTOPost;
import com.example.MAShop.DTOS.response.UserDTOResponse;
import com.example.MAShop.models.User;
import com.example.MAShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController("/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping()
    public ResponseEntity<List<UserDTOResponse>> findAll(){
        List<UserDTOResponse> userDTOResponse = userService.findAll();
        return ResponseEntity.ok().body(userDTOResponse);
    }
    
    @PostMapping("/")
    public ResponseEntity<User> save(UserDTOPost user){
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User>  getById(@PathVariable UUID id){
        return userService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Optional<User> update(@RequestBody User user, @PathVariable UUID id){
        return userService.update(user, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(UUID id){
        if(userService.deleteById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
}
