package com.ironhack.vbnk_gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/v1/security/**")
//                        .filters(f -> f.addRequestHeader())
                        .uri("lb://VBNK-AUTHENTICATION-SERVICE"))
                .route(p -> p.path("/v1/data/**")
                        .uri("lb://VBNK-DATA-SERVICE"))
                .route(p -> p.path("/v1/trans/**")
                        .uri("lb://VBNK-TRANSACTION-SERVICE"))
                .route(p -> p.path("/v1/anti-fraud/**")
                        .uri("lb://VBNK-ANTI-FRAUD-SERVICE"))
                .build();
    }
}
