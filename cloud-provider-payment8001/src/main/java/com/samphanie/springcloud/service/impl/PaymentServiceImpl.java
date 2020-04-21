package com.samphanie.springcloud.service.impl;

import com.samphanie.springcloud.dao.PaymentDao;
import com.samphanie.springcloud.entities.Payment;
import com.samphanie.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname PaymentServiceImpl
 * @Date 2020/4/19 13:51
 * @Author ZSY
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Resource
    private PaymentDao paymentDao;


    /**
     * 创建订单
     *
     * @param payment
     * @return void
     */
    @Override
    public int create(Payment payment) {

        return paymentDao.create(payment);

    }

    /**
     * 查询订单
     *
     * @param id
     * @return Payment
     */
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
