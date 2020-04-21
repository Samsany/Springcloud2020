package com.samphanie.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname PaymentMain8001
 * @Date 2020/4/17 20:25
 * @Author ZSY
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.samphanie.springcloud.dao")
public class PaymentMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }

}
