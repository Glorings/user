package com.example.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product")
public interface ProductService {

    @GetMapping("/product/{userId}")
    public  String getProduc(@PathVariable("userId") Long userId);

}
