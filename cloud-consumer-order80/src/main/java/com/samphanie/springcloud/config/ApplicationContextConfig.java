package com.samphanie.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname ApplicationContextConfig
 * @Date 2020/4/19 15:36
 * @Author ZSY
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 使用 @LoadBalanced 注解赋予RestTemplate负载均衡的能力
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
