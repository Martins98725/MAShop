package com.example.MAShop.services.Impl;

import com.example.MAShop.DTOS.request.StoreDTOPost;
import com.example.MAShop.DTOS.request.StoreDTOUpdate;
import com.example.MAShop.DTOS.response.StoreDTO;
import com.example.MAShop.DTOS.response.StoreDTOById;
import com.example.MAShop.mappers.StoreMapper;
import com.example.MAShop.models.Store;
import com.example.MAShop.repositories.StoreRepository;
import com.example.MAShop.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<StoreDTO> findAll() {
        List<Store> stores;
        stores = storeRepository.findAll();
        return StoreMapper.INSTANCE.storeDTOListToStoreDTOList(stores);
    }

    @Override
    public StoreDTOPost save(StoreDTOPost storeDTOPost) {
        Store store = StoreMapper.INSTANCE.storeDTOPostToStore(storeDTOPost);
        store = storeRepository.save(store);
        return StoreMapper.INSTANCE.storeToStoreDTOPost(store);
    }

    @Override
    public Optional<StoreDTOById> findById(UUID id) {
        StoreDTOById storeDTO = new StoreDTOById();

        Store store = StoreMapper.INSTANCE.storeDTOByIdToStore(storeDTO);
        store.setId(id);

        store = storeRepository.findById(id).orElse(null);

        return Optional.of(StoreMapper.INSTANCE.storeDTOByIdToStoreDTO(store));
    }

    @Override
    public Optional<StoreDTOUpdate> update(StoreDTOUpdate storeDTO, UUID id) {
        if (storeRepository.existsById(id)) {
            Store store = StoreMapper.INSTANCE.storeDTOUpdateToStore(storeDTO);

            store.setId(id);
            store = storeRepository.save(store);

            return Optional.of(StoreMapper.INSTANCE.storeDTOUpdateToStore(store));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (storeRepository.existsById(id)) {
            storeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
