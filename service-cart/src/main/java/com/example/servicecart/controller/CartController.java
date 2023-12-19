package com.example.servicecart.controller;

import com.example.servicecart.entity.Cart;
import com.example.servicecart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class CartController {

    @Autowired
    private CartService cartService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/carts/{userName}/{productId}")
    public Cart addToCart(@PathVariable(name = "userName") String userName, @PathVariable(name = "productId") Integer productId) {
        return cartService.addToCart(userName, productId);
    }

    @DeleteMapping("/carts/{cartId}")
    public void deleteCartItem(@PathVariable(name = "cartId") Integer cartId) {
        cartService.deleteCartItem(cartId);
    }

    @GetMapping("/carts/{userName}")
    public List<Cart> getCartDetails(@PathVariable(name = "userName") String userName) {
        return cartService.getCartDetails(userName);
    }

    //Get cart by username



}
