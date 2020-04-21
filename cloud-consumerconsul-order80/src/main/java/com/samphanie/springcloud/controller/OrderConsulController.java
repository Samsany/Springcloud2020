package com.samphanie.springcloud.controller;

import com.samphanie.springcloud.constant.OrderConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Classname OrderController
 * @Date 2020/4/20 19:19
 * @Author ZSY
 */
@RestController
@Slf4j
public class OrderConsulController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo() {

        return restTemplate.getForObject(OrderConst.PAYMENT_CONSUL_URL + "/payment/consul", String.class);

    }

}
