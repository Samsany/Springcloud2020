package com.samphanie.springcloud.service;

import com.samphanie.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname IPaymentService
 * @Date 2020/4/19 13:50
 * @Author ZSY
 */
public interface IPaymentService {

    /**
     * 创建订单
     *
     * @param payment
     * @return void
     */
    int create(Payment payment);

    /**
     * 查询订单
     *
     * @param id
     * @return Payment
     */
    Payment getPaymentById(@Param("id") Long id);

}
