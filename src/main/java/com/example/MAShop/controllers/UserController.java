package com.example.MAShop.controllers;

import com.example.MAShop.DTOS.request.UserDTOPost;
import com.example.MAShop.DTOS.response.UserDTOResponse;
import com.example.MAShop.DTOS.response.UserDTOResponseById;
import com.example.MAShop.models.User;
import com.example.MAShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping()
    public ResponseEntity<List<UserDTOResponse>> findAll(){
        List<UserDTOResponse> userDTOResponseAll = userService.findAll();
        return ResponseEntity.ok().body(userDTOResponseAll);
    }
    
    @PostMapping("/")
    public ResponseEntity<UserDTOPost> saveUser(@RequestBody UserDTOPost user){
        var userDTOPost = userService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(userDTOPost);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserDTOResponseById>  getById(@PathVariable UUID id){
        return userService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Optional<User> update(@RequestBody User user, @PathVariable UUID id){

        return userService.update(user, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable UUID id){
        if(userService.deleteById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
}
