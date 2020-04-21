package com.samphanie.springcloud.controller;

import com.samphanie.springcloud.constant.OrderConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Classname orderZkController
 * @Date 2020/4/20 16:16
 * @Author ZSY
 */
@RestController
@Slf4j
public class OrderZkController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo() {

        return restTemplate.getForObject(OrderConst.PAYMENT_ZOOKEEPER_URL + "/payment/zk", String.class);

    }

}
