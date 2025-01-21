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
@Table(name = "TB_PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @Column(name = "NAME", nullable = false, length = 75)
    private String name;

    @NotBlank
    @Column(name = "DESCRIPTION", nullable = false, length = 75)
    private String description;
    @NotBlank
    @Column(name = "PRICE", nullable = false, length = 75)
    private double price;

    @NotBlank
    @Column(name = "QUANTITY", nullable = false, length = 75)
    private int quantity;

    @NotBlank
    @Column(name = "IMAGE", nullable = false, length = 75)
    private String image;

    @NotBlank
    @Column(name = "BARCODE", nullable = false, length = 75)
    private String barcode;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(
            name = "PRODUCT_STORE",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "STORE_ID")
    )
    private List<Store> stores;
}
