package com.example.MAShop.DTOS.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateDTO {
    private UUID id;
    private String name;
    private String description;
    private double price;
    private String image;
}
