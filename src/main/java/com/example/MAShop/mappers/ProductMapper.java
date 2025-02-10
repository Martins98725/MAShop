package com.example.MAShop.mappers;

import com.example.MAShop.DTOS.request.ProductDTOPost;
import com.example.MAShop.DTOS.response.ProductDTOResponseAll;
import com.example.MAShop.DTOS.response.StoreDTO;
import com.example.MAShop.models.Product;
import com.example.MAShop.models.Store;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product productToProductDTOPost(ProductDTOPost productDTOPost);

    ProductDTOPost productToProductDTOPost(Product product);

    List<ProductDTOResponseAll> productListToProductDTOResponseAllList(List<Product> product);

    ProductDTOResponseAll productToProductDTOResponseAll(Product product);

    Product productDTOResponseToProduct(ProductDTOResponseAll productDTOResponseAll);

    StoreDTO storeToStoreDTO(Store store);

    Store storeDTOToStore(StoreDTO storeDTO);

    List<StoreDTO> productToStoreDTO(List<Store> products);

    List<Store> productDTOToStore(List<StoreDTO> stores );
}
