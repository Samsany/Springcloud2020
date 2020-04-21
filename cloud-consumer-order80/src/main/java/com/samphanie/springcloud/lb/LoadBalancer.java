package com.samphanie.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Classname LoadBalancer
 * @Date 2020/4/20 21:20
 * @Author ZSY
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
