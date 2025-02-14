package com.example.MAShop.DTOS.request;

import com.example.MAShop.DTOS.response.UserDTOResponse;
import com.example.MAShop.models.Product;
import com.example.MAShop.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOPost {
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private double price;
    @NotBlank
    private String image;
    @NotBlank
    private UUID storeId;

}
