package com.example.servicecart.client;

import com.example.servicecart.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "service-user", url = "http://service-user:8080")
public interface UserClient {


    @GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable("username") String username);
}
