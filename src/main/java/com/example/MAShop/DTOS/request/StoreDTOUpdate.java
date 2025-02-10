package com.example.MAShop.DTOS.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTOUpdate {
    private UUID id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String cnpj;
}
