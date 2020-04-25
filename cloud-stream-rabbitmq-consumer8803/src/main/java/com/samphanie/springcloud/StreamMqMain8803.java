package com.samphanie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname StreamMqMain8803
 * @Date 2020/4/25 23:49
 * @Author ZSY
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMqMain8803 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMqMain8803.class, args);
    }

}
