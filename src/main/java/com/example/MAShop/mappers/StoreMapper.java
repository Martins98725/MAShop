package com.example.MAShop.mappers;

import com.example.MAShop.DTOS.request.StoreDTOPost;
import com.example.MAShop.models.Store;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoreMapper {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    Store storeDTOPostToStore(StoreDTOPost storeDTOPost);

    StoreDTOPost storeToStoreDTO(Store store);
}
