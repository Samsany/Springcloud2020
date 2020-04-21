package com.samphanie.springcloud.service;

import com.samphanie.springcloud.entities.Payment;
import com.samphanie.springcloud.vo.CommonResult;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname IPaymentService
 * @Date 2020/4/20 23:33
 * @Author ZSY
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface IPaymentFeignService {

    @GetMapping("/payment/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Long id);

    @GetMapping("/payment/fegin/timeout")
    String paymentFeginTimeout();

}
