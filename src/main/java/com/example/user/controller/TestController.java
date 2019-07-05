package com.example.user.controller;

import com.example.user.service.ProductService;
import com.netflix.discovery.converters.Auto;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author wujun
 * @version 1.0.0
 * @description:
 * @date 2019-07-05 09:19
 * Copyright 本内容仅限于浙江名信信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */

@RestController
public class TestController {

    @Autowired
    ProductService productService;

    @GetMapping("/feign")
    public String test(){
       return  productService.getProduc(1L);
    }

}
