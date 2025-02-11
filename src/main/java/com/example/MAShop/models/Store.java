package com.example.MAShop.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_STORE")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @Column(name = "NAME", nullable = false, length = 75)
    private String name;

    @NotBlank
    @Column(name = "ADRESS", nullable = false, length = 75)
    private String address;

    @NotBlank
    @Column(name = "PHONE", nullable = false, length = 75)
    private String phone;

    @NotBlank
    @Column(name = "EMAIL", nullable = false, length = 75)
    private String email;

    @NotBlank
    @Column(name = "CNPJ", nullable = false, length = 75)
    private String cnpj;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
    private List<Product> products;

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
