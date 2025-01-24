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
    @Column(name = "NAME", length = 75)
    private String name;

    @NotBlank
    @Column(name = "DESCRIPTION", length = 75)
    private String description;
    @NotBlank
    @Column(name = "PRICE", length = 75)
    private double price;

    @NotBlank
    @Column(name = "QUANTITY", length = 75)
    private int quantity;

    @NotBlank
    @Column(name = "IMAGE", length = 75)
    private String image;

    @NotBlank
    @Column(name = "BARCODE", length = 75)
    //diferenciar os produtos pelo barcode
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

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
