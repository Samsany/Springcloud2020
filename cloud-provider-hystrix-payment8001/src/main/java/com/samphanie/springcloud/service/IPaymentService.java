package com.samphanie.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname IPaymentService
 * @Date 2020/4/21 19:52
 * @Author ZSY
 */
public interface IPaymentService {

    String paymentInfoOk(Integer id);

    String paymentInfoTimeout(Integer id);

    String paymentCircuitBreaker(Integer id);

}
