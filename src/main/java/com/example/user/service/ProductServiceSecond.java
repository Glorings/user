package com.example.user.service;

import com.example.user.client.RiskClientFallback;
import com.example.user.client.RiskClientsConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( value = "product")
public interface ProductServiceSecond {

    @GetMapping("/product/{userId}")
    public  String getProduc2(@PathVariable("userId") Long userId);

}
