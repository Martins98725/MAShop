package com.example.MAShop.DTOS.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTOById {
    private UUID id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String cnpj;
    private List<ProductDTOResponse> products;
}
