package com.samphanie.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.samphanie.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    /**
     * 服务熔断
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("********id 不能为负数");
        }

        String serialNum = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNum;
    }

    public String paymentCircuitBreakerFallback(Integer id) {

        return "id 不能为负数,请稍后再试，(ノへ￣、)  id:" + id;

    }

}
