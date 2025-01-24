package com.example.MAShop.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @Column(name = "NAME", length = 75)
    private String name;

    @NotBlank
    @Column(name = "USERNAME", unique = true, length = 75)
    private String username;

    @NotBlank
    @Column(name = "PASSWORD", length = 15)
    private String password;

    @Email
    @NotBlank
    @Column(name = "EMAIL", unique = true, length = 75)
    private String email;

    @NotBlank
    @Column(name = "PHONE", length = 9)
    private String phone;

    @NotBlank
    @Column(name = "ADRESS", length = 100)
    private String address;

    @NotBlank
    @Column(name = "ZIPCODE", length = 10)
    private String zipcode;

    private String role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Product> products;

}
