package com.saltedge.connector.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
@ComponentScan("com.saltedge")
@EnableConfigurationProperties(SaltEdgeProperties.class)
public class SaltEdgeConfig {
    @Bean
    public WebClient webClient(SaltEdgeProperties properties) {
        HttpClient httpClient = HttpClient.create();
        return WebClient.builder()
                .baseUrl(properties.getApiUrl())
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Content-type", "application/json")
                .defaultHeader("App-id", properties.getAppId())
                .defaultHeader("Secret", properties.getSecret())
                .build();
    }
} 