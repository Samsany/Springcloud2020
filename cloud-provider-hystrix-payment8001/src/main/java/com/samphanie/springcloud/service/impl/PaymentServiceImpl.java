package com.samphanie.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.samphanie.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Classname PaymentServiceImpl
 * @Date 2020/4/21 19:52
 * @Author ZSY
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfoOK" + id + "\t" + "O(∩_∩)O哈哈~~~~";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeout(Integer id) {

        int timeNumber = 3000;

        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "线程池：" + Thread.currentThread().getName() + "\t" +  "ID:" + id + "\t" + "O(∩_∩)O哈哈~~~~" + "耗时" + timeNumber + "ms";
    }

    public String paymentInfoTimeoutHandler(Integer id) {

        return "线程池：" + Thread.currentThread().getName() + "8001系统繁忙或者运行报错，请稍后重试，ID:" + id + "\t" + "⊙﹏⊙∥";
    }


}
