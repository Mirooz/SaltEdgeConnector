package com.saltedge.connector.service;

import com.saltedge.connector.model.Provider;
import com.saltedge.connector.model.response.SaltEdgeResponse;
import com.saltedge.connector.model.response.SaltEdgeSingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class ProviderService {

    private final SaltEdgeService saltEdgeService;

    @Autowired
    public ProviderService(SaltEdgeService saltEdgeService) {
        this.saltEdgeService = saltEdgeService;
    }

    public Flux<Provider> getAllProviders() {
        return saltEdgeService.get("/providers", new ParameterizedTypeReference<SaltEdgeResponse<Provider>>() {})
                .flatMapMany(response -> Flux.fromIterable(response.getData()));
    }

    public Mono<Provider> getProvider(String code) {
        return saltEdgeService.get("/providers/" +code, new ParameterizedTypeReference<SaltEdgeSingleResponse<Provider>>() {})
                .map(SaltEdgeSingleResponse::getData);
    }

    public Flux<Provider> getProviders(Map<String, Object> params) {
        return saltEdgeService.get("/providers", new ParameterizedTypeReference<SaltEdgeResponse<Provider>>() {}, params)
                .flatMapMany(response -> Flux.fromIterable(response.getData()));
    }

} 