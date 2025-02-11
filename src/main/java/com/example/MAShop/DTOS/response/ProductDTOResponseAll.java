package com.example.MAShop.DTOS.response;


import com.example.MAShop.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOResponseAll {
    private UUID id;
    private String name;
    private String description;
    private double price;
    private String image;
    private StoreDTO store;

}
