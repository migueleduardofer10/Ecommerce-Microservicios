package com.example.servicecart.repository;

import com.example.servicecart.entity.Cart;
import com.example.servicecart.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDao extends CrudRepository<Cart, Integer > {
    List<Cart> findByUserName(String userName);
}


