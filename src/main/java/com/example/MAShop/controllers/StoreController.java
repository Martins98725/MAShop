package com.example.MAShop.controllers;

import com.example.MAShop.DTOS.request.StoreDTOPost;
import com.example.MAShop.DTOS.request.StoreDTOUpdate;
import com.example.MAShop.DTOS.request.UserDTOPost;
import com.example.MAShop.DTOS.response.StoreDTO;
import com.example.MAShop.DTOS.response.StoreDTOById;
import com.example.MAShop.DTOS.response.UserDTOResponse;
import com.example.MAShop.DTOS.response.UserDTOResponseById;
import com.example.MAShop.models.Store;
import com.example.MAShop.models.User;
import com.example.MAShop.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping()
    public ResponseEntity<List<StoreDTO>> findAll(){
        List<StoreDTO> storeDTOList = storeService.findAll();

        return ResponseEntity.ok().body(storeDTOList);
    }

    @PostMapping("/")
    public ResponseEntity<StoreDTOPost> saveUser(@RequestBody StoreDTOPost storeDTOPost){
        StoreDTOPost savedStoreDTOPost = storeService.save(storeDTOPost);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedStoreDTOPost);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDTOById>  getById(@PathVariable UUID id){
        return storeService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Optional<StoreDTOUpdate> update(@RequestBody StoreDTOUpdate storeDTOUpdate, @PathVariable UUID id){
        return storeService.update(storeDTOUpdate,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Store> deleteById(@PathVariable UUID id){
        if(storeService.deleteById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
