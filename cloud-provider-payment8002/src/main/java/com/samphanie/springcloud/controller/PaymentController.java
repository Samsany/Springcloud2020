package com.samphanie.springcloud.controller;

import com.samphanie.springcloud.entities.Payment;
import com.samphanie.springcloud.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.samphanie.springcloud.service.IPaymentService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Classname PaymentController
 * @Date 2020/4/19 13:56
 * @Author ZSY
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {

        int result = paymentService.create(payment);
        log.info("【创建订单结果】result={}" ,result);
        if (result > 0) {
            return CommonResult.success(200, "插入成功,severPort=" + serverPort, result);
        } else {
            return CommonResult.error(444, "插入失败");
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymentById(id);
        log.info("【查询订单结果】result={}" ,payment);
        if (payment != null) {
            return CommonResult.success(200, "查询订单成功,severPort=" + serverPort, payment);
        } else {
            return CommonResult.error(444, "没有该条数据");
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLb() {
        return serverPort;
    }

    @GetMapping("/payment/fegin/timeout")
    public String paymentFeginTimeout() {

        // 暂停几秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return serverPort;
    }

}
