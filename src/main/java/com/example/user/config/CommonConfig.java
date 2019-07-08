package com.example.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 系统公共配置信息类，支持配置刷新
 *
 * @author chengkang
 */
@Component
@RefreshScope
public class CommonConfig {

    @Value("${switch.test}")
    String switchTest;

    public String getSwitchTest() {
        return switchTest;
    }

    public void setSwitchTest(String switchTest) {
        this.switchTest = switchTest;
    }
}
