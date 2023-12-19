package com.example.servicecart.service;

import com.example.servicecart.client.ProductClient;
import com.example.servicecart.client.UserClient;
import com.example.servicecart.entity.Cart;
import com.example.servicecart.model.Product;
import com.example.servicecart.model.User;
import com.example.servicecart.repository.CartDao;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartDao cartDao;

    @Autowired
    UserClient userClient;

    @Autowired
    ProductClient productClient;

    public void deleteCartItem(Integer cartId) {
        cartDao.deleteById(cartId);
    }

    public Cart addToCart(String userName, Integer productId) {
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (productId == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }

        Product product = productClient.getProductDetailsById(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }

        User userResponse = userClient.getUserByUsername(userName);
        if (userResponse == null) {
            throw new IllegalArgumentException("User not found");
        }
        String user = userResponse.getUserName();


        Cart cart = new Cart(productId, user);
        return cartDao.save(cart);
    }

    public List<Cart> getCartDetails(String userName) {
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        User userResponse = userClient.getUserByUsername(userName);
        if (userResponse == null) {
            throw new IllegalArgumentException("User not found");
        }
        String user = userResponse.getUserName();

        List<Cart> carts = cartDao.findByUserName(user);

        // Añade detalles del producto y del usuario a cada elemento del carrito
        for (Cart cart : carts) {
            Product product = productClient.getProductDetailsById(cart.getProductId());
            cart.setProduct(product);
            cart.setUser(userResponse); // Asigna el objeto User al carrito
        }

        return carts;
    }
}
