package com.example.servicecart.entity;

import com.example.servicecart.model.Product;
import com.example.servicecart.model.User;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "productId")
    private Integer productId;

    @Transient
    private Product product;
    @Transient
    private User user;

    public Cart(){

    }

    public Cart(Integer product, String user) {
        this.productId = product;
        this.userName = user;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
