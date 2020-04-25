package com.samphanie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname StreamMQMain8801
 * @Date 2020/4/25 23:49
 * @Author ZSY
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMqMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMqMain8801.class, args);
    }

}
