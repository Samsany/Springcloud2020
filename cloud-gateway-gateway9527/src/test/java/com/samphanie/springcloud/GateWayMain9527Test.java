package com.samphanie.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

/**
 * @Classname GateWayMain9527Test
 * @Date 2020/4/23 23:23
 * @Author ZSY
 */
@SpringBootTest
@Slf4j
public class GateWayMain9527Test {

    @Test
    public void getDateTime() {
        ZonedDateTime zonedDateTime  = ZonedDateTime.now(); // 默认时区

        log.info("【当前时间】 zonedDateTime：" + zonedDateTime);

    }

}
