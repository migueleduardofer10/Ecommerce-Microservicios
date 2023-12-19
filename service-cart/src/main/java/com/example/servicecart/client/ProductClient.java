package com.example.servicecart.client;

import com.example.servicecart.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name = "service-product", url = "http://service-product:9090")
public interface ProductClient {

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable("productId") Integer productId);

    @GetMapping("/products/{productId}")
    public Product getProductDetailsById(@PathVariable("productId") Integer productId);
}
