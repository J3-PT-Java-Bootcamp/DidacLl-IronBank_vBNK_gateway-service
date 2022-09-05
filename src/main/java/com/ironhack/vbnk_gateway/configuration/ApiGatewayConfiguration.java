package com.ironhack.vbnk_gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p.path("/data/**")
                        .uri("lb://VBNK-DATA-SERVICE"))
                .route(p -> p.path("/transactions/**")
                        .uri("lb://VBNK-TRANSACTION-SERVICE"))
                .route(p -> p.path("/anti-fraud/**")
                        .uri("lb://VBNK-ANTI-FRAUD-SERVICE"))
                .build();
    }
}