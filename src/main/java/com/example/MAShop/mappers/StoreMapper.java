package com.example.MAShop.mappers;

import com.example.MAShop.DTOS.request.StoreDTOPost;
import com.example.MAShop.DTOS.request.StoreDTOUpdate;
import com.example.MAShop.DTOS.response.StoreDTO;
import com.example.MAShop.DTOS.response.StoreDTOById;
import com.example.MAShop.DTOS.response.StoreDTOProduct;
import com.example.MAShop.models.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StoreMapper {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    Store storeDTOPostToStore(StoreDTOPost storeDTOPost);

    StoreDTOPost storeToStoreDTOPost(Store store);

    Store storeDTOByIdToStore(StoreDTOById storeDTOById);

    StoreDTOById storeDTOByIdToStoreDTO(Store store);

    Store storeDTOToStore(StoreDTO storeDTO);

    StoreDTO storeToStoreDTO(Store store);

    List<StoreDTO> storeDTOListToStoreDTOList(List<Store> stores);

    Store storeDTOUpdateToStore(StoreDTOUpdate storeDTOUpdate);

    StoreDTOUpdate storeDTOUpdateToStore(Store store);

    Store storeDTOProductToStore(StoreDTOProduct storeDTOProduct);
}
