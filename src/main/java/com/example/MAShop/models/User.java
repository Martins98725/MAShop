package com.example.MAShop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @Column(name = "NAME", length = 75, nullable = false)
    private String name;

    @NotBlank
    @Column(name = "USERNAME", unique = true, length = 75, nullable = false)
    private String username;

    @NotBlank
    @Column(name = "PASSWORD", length = 15, nullable = false)
    private String password;

    @Email
    @NotBlank
    @Column(name = "EMAIL", unique = true, length = 75, nullable = false)
    private String email;

    @NotBlank
    @Column(name = "PHONE", length = 9, nullable = false)
    private String phone;

    @NotBlank
    @Column(name = "ADDRESS", length = 100, nullable = false)
    private String address;

    @NotBlank
    @Column(name = "ZIPCODE", length = 10, nullable = false)
    private String zipcode;

    @NotBlank
    @Column(name = "ROLE", length = 10, nullable = false)
    private String role;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Cart cart;

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

}
