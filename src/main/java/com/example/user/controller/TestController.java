package com.example.user.controller;

//import com.example.user.client.ProductClientConfiguration;
import com.example.user.service.ProductService;
import com.example.user.service.ProductServiceSecond;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
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

    protected final Logger logger = LoggerFactory.getLogger( this.getClass());

    @Autowired
    ProductService productService;
    @Autowired
    ProductServiceSecond productServiceSecond;

    @GetMapping("/feign")
    public String test(){
       return  productService.getProduc(1L);
    }

/*    @GetMapping("/feign2")
    @HystrixCommand(fallbackMethod="error",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String test2(){
        return  productServiceSecond.getProduc2(1L);
    }*/

    public String error(){
        return  "error";
    }

    @GetMapping("/user/testZuul")
    public String testZuul(){
        return  "TTTT";
    }

    @GetMapping("/testZuul")
    public String testZuul2(){
        logger.info("PPPPPPPPPPPPPPPPPPPPPPPPPPP");
        return  "YYYY";
    }

    @GetMapping("/testZuul3")
    public String testZuul3(){
        int result =  1/0;
        return  "YYYY";
    }

    @PostMapping("/testZuul4")
    public String testZuul4(){
        logger.info("PPPPPPPPPPPPPPPPPPPPPPPPPPP");
        return  "YYYY";
    }

    @GetMapping("/testZuul5")
    public String testZuul5() throws Exception {
        //int result =  1/0;
        throw   new Exception("error");
    }

}
