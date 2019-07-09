package com.example.user.controller;

//import com.example.user.client.ProductClientConfiguration;
import com.example.user.config.CommonConfig;
import com.example.user.service.FileUploadFeignService;
import com.example.user.service.ProductService;
import com.example.user.service.ProductServiceSecond;
import com.example.user.service.bo.UserBo;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.jws.soap.SOAPBinding;
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
    FileUploadFeignService fileUploadFeignService;
    @Autowired
    ProductServiceSecond productServiceSecond;
    @Value("${switch.test}")
    String switchTest;

    @Autowired
    CommonConfig commonConfig;

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

    @GetMapping("/testConfig")
    public String testConfig() throws Exception {
        logger.info("switchTest");
        logger.info(commonConfig.getSwitchTest());
        return switchTest;
    }

    @GetMapping("/feignParamGet")
    public String feignParamGet(){
        UserBo userBo = new UserBo();
        userBo.setName("Glorings");
        userBo.setAge(18);
        return  productService.productParamGet(userBo);
    }

    @GetMapping("/feignParamPost")
    public String feignParamPost(){
        UserBo userBo = new UserBo();
        userBo.setName("Glorings");
        userBo.setAge(19);
        return  productService.productParamPost(userBo);
    }

    @RequestMapping(value = "/testUpload", consumes = "multipart/*")
    public String imageUpload(@RequestParam(value = "file",required = true) MultipartFile file) throws Exception{
        return fileUploadFeignService.fileUpload(file);
    }

}
