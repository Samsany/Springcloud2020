package com.samphanie.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Classname ReceiveMessageListenerController
 * @Date 2020/4/26 0:50
 * @Author ZSY
 */
@EnableBinding(Sink.class)
@Slf4j
@Component
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("【消费者二号，---------------> 接收到消息】 msg：" + message.getPayload() + "\t" + serverPort);
    }

}
