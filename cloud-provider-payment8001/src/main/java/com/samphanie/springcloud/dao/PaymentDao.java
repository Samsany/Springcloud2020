package com.samphanie.springcloud.dao;

import com.samphanie.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author ZSY
 * @Date 2020/4/17 21:03
 */
public interface PaymentDao {

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
