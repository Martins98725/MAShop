package com.example.MAShop.services;

import com.example.MAShop.DTOS.request.ProductDTOPost;
import com.example.MAShop.DTOS.request.StoreDTOPost;
import com.example.MAShop.DTOS.request.StoreDTOUpdate;
import com.example.MAShop.DTOS.response.ProductDTOResponseAll;
import com.example.MAShop.DTOS.response.StoreDTO;
import com.example.MAShop.DTOS.response.StoreDTOById;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StoreService {

    List<StoreDTO> findAll();

    StoreDTOPost save(StoreDTOPost storeDTOPost);

    Optional<StoreDTOById> findById(UUID id);

    Optional<StoreDTOUpdate> update(StoreDTOUpdate storeDTO, UUID id);

    boolean deleteById(UUID id);
}
