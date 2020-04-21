package com.samphanie.springcloud.controller;

import com.samphanie.springcloud.entities.Payment;
import com.samphanie.springcloud.service.IPaymentFeignService;
import com.samphanie.springcloud.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname OrderFeginController
 * @Date 2020/4/20 23:32
 * @Author ZSY
 */
@RestController
@Slf4j
public class OrderFeginController {

    @Resource
    private IPaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymentFeignService.getPayment(id);
    }

    @GetMapping("/consumer/payment/fegin/timeout")
    public String paymentFeginTimeout() {
        return paymentFeignService.paymentFeginTimeout();
    }

}
