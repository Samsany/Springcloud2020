package com.samphanie.springcloud.controller;

import com.samphanie.springcloud.constant.OrderConst;
import com.samphanie.springcloud.entities.Payment;
import com.samphanie.springcloud.lb.LoadBalancer;
import com.samphanie.springcloud.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Classname OrderController
 * @Date 2020/4/19 15:34
 * @Author ZSY
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {

        return restTemplate.postForObject(OrderConst.PAYMENT_EUREKA_URL + "/payment/create", payment,CommonResult.class);

    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {

        return restTemplate.getForObject(OrderConst.PAYMENT_EUREKA_URL + "/payment/" + id,CommonResult.class);

    }

    @GetMapping("/consumer/payment/getForEntity/create")
    public CommonResult<Payment> create2(Payment payment) {

        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(OrderConst.PAYMENT_EUREKA_URL + "/payment/create", payment, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return CommonResult.fail();
        }

    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {

        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(OrderConst.PAYMENT_EUREKA_URL + "/payment/" + id, CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return CommonResult.fail();
        }

    }


    @GetMapping("/consumer/payment/lb")
    public String getPaymentLb() {

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances == null || instances.size() <= 0){
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);

        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb",String.class);

    }


}
