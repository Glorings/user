package com.example.user.client;

import com.example.user.service.ProductService;
import feign.hystrix.FallbackFactory;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务降级
 */
@Component
public class RiskClientFallback implements FallbackFactory<ProductService> {

    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ProductService create(Throwable throwable) {
        return new ProductService() {
            @Override
            public String getProduc(Long userId) {
                logger.info("TTTTTTTTTTT");
                return "TTTT";
            }
        };
    }

}
