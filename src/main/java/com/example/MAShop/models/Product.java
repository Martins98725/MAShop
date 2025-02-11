package com.example.MAShop.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
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

   /* @NotBlank
    @Column(name = "QUANTITY", length = 75)
    private int quantity;*/

    @NotBlank
    @Column(name = "IMAGE", length = 75)
    private String image;

 /*   @NotBlank
    @Column(name = "BARCODE", length = 75)
    //diferenciar os produtos pelo barcode
    private Double barcode;*/

    @ManyToOne
    private Cart cart;


    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
