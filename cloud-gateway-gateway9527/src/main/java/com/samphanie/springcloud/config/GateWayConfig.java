package com.samphanie.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname GateWayConfig
 * @Date 2020/4/23 22:59
 * @Author ZSY
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_samphanie",r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        routes.route("path_route_samphanie1",r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();


        return routes.build();

    }
}
