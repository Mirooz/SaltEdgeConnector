package com.saltedge.connector.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
@ComponentScan("com.saltedge")
public class SaltEdgeConfig {

    @Value("${saltedge.api.url}")
    private String apiUrl;

    @Value("${saltedge.app-id}")
    private String appId;

    @Value("${saltedge.secret}")
    private String secret;

    @Bean
    public WebClient webClient() {
        HttpClient httpClient = HttpClient.create();
        return WebClient.builder()
                .baseUrl(apiUrl)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Content-type", "application/json")
                .defaultHeader("App-id", appId)
                .defaultHeader("Secret", secret)
                .build();
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getAppId() {
        return appId;
    }

    public String getSecret() {
        return secret;
    }
} 