package com.samphanie.springcloud.lb.impl;

import com.samphanie.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname MyLBImpl
 * @Date 2020/4/20 21:23
 * @Author ZSY
 */
@Component
public class MyLbImpl implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int getAndIncrement() {
        int current;
        int next;

        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while(!this.atomicInteger.compareAndSet(current,next));

        System.out.println("******第几次访问，次数next:" + next);

        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
