package com.example.MAShop.DTOS.response;

import com.example.MAShop.models.Product;
import com.example.MAShop.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOResponse {
    private UUID id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String zipcode;
    private String role;

    private List<Product> carshop;

    public UserDTOResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.zipcode = user.getZipcode();
        this.role = user.getRole();

        this.carshop = user.getProducts();

        /*Product product = new Product();
        product.setId(user.getProducts().get(0).getId());
        product.setName(user.getProducts().get(0).getName());
        product.setPrice(user.getProducts().get(0).getPrice());
        product.setQuantity(user.getProducts().get(0).getQuantity());
        product.setDescription(user.getProducts().get(0).getDescription());

        this.carshop = user.getProducts();*/
    }
}
