package com.example.user.service;

import com.example.user.client.RiskClientFallback;
import com.example.user.client.RiskClientsConfiguration;
import com.example.user.service.bo.UserBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient( value = "product",fallbackFactory = RiskClientFallback.class)
public interface ProductService {

    @GetMapping("/product/{userId}")
    public  String getProduc(@PathVariable("userId") Long userId);

    //注意此处不能使用@RequestBody，否则失效
    @GetMapping("/productParamGet")
    public  String productParamGet(UserBo user);

    @PostMapping("/productParamPost")
    public  String productParamPost(@RequestBody UserBo user);

}
