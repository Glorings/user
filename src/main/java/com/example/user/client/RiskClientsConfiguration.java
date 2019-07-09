package com.example.user.client;

import feign.Request;
import feign.Retryer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RiskClientsConfiguration {
   /* @Value("${host.feign.request.connectTimeoutMillis}")
    int connectTimeoutMillis;
    @Value("${host.feign.request.readTimeoutMillis}")
    int readTimeoutMillis;

    @Bean
    @Scope("prototype")
    public Request.Options feginOption(){
        //读取与连接超时，有一个超时了都会降级
        Request.Options option = new Request.Options(connectTimeoutMillis,readTimeoutMillis);
        return option;
    }*/
    
}
