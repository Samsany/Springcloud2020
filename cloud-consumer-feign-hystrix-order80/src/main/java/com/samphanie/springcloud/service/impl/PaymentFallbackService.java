package com.samphanie.springcloud.service.impl;

import com.samphanie.springcloud.service.IPaymentHystrixServiceImpl;
import org.springframework.stereotype.Component;

/**
 * @Classname PaymentFallbackService
 * @Date 2020/4/22 0:25
 * @Author ZSY
 */
@Component
public class PaymentFallbackService implements IPaymentHystrixServiceImpl {
    @Override
    public String paymentInfoOk(Integer id) {
        return "***************************PaymentFallbackService fall back paymentInfoOk, (ノへ￣、)";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "***************************PaymentFallbackService fall back paymentInfoTimeout, (ノへ￣、)";
    }
}
