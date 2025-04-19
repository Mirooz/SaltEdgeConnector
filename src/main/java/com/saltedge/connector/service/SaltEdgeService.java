package com.saltedge.connector.service;

import com.saltedge.connector.config.SaltEdgeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class SaltEdgeService {

    private final WebClient webClient;

    @Autowired
    public SaltEdgeService(WebClient webClient) {
        this.webClient = webClient;
    }

    public <T> Mono<T> get(String path, Class<T> responseType) {
        return webClient.get()
                .uri(path)
                .retrieve()
                .bodyToMono(responseType);
    }

    public <T> Mono<T> get(String path, Class<T> responseType, Map<String, Object> params) {
        return webClient.get()
                .uri(uriBuilder -> {
                    params.forEach(uriBuilder::queryParam);
                    return uriBuilder.path(path).build();
                })
                .retrieve()
                .bodyToMono(responseType);
    }

    public <T> Mono<T> get(String path, ParameterizedTypeReference<T> responseType) {
        return webClient.get()
                .uri(path)
                .retrieve()
                .bodyToMono(responseType);
    }

    public <T> Mono<T> get(String path, ParameterizedTypeReference<T> responseType, Map<String, Object> params) {
        return webClient.get()
                .uri(uriBuilder -> {
                    params.forEach(uriBuilder::queryParam);
                    return uriBuilder.path(path).build();
                })
                .retrieve()
                .bodyToMono(responseType);
    }
    public <T, R> Mono<T> post(String endpoint, R requestBody,Class<T> responseType) {
        return webClient.post()
                .uri(endpoint)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(responseType);
    }
    public <T, R> Mono<T> post(String endpoint, R requestBody, ParameterizedTypeReference<T> responseType) {
        return webClient.post()
                .uri(endpoint)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(responseType);
    }

    public <T, R> Mono<T> put(String endpoint, R requestBody, Class<T> responseType) {
        return webClient.put()
                .uri(endpoint)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(responseType);
    }

    public <T, R> Mono<T> put(String endpoint, R requestBody, ParameterizedTypeReference<T> responseType) {
        return webClient.put()
                .uri(endpoint)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(responseType);
    }

    public <T> Mono<T> delete(String endpoint, Class<T> responseType) {
        return webClient.delete()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(responseType);
    }
    public <T> Mono<T> delete(String endpoint,  ParameterizedTypeReference<T> responseType) {
        return webClient.delete()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(responseType);
    }
} 