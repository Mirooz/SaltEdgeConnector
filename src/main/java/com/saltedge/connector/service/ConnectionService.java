package com.saltedge.connector.service;

import com.saltedge.connector.model.Connection;
import com.saltedge.connector.model.response.SaltEdgeResponse;
import com.saltedge.connector.model.response.SaltEdgeSingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class ConnectionService {

    private final SaltEdgeService saltEdgeService;

    @Autowired
    public ConnectionService(SaltEdgeService saltEdgeService) {
        this.saltEdgeService = saltEdgeService;
    }

    public Flux<Connection> getAllConnections() {
        return saltEdgeService.get("/connections", new ParameterizedTypeReference<SaltEdgeResponse<Connection>>() {})
                .flatMapMany(response -> Flux.fromIterable(response.getData()));
    }

    public Mono<Connection> getConnection(String connectionId) {
        return saltEdgeService.get("/connections/" + connectionId, new ParameterizedTypeReference<SaltEdgeSingleResponse<Connection>>() {})
                .map(SaltEdgeSingleResponse::getData);
    }

    public Mono<Connection> createConnection(String customerId, String providerCode, String countryCode) {
        Map<String, Object> requestBody = Map.of(
                "data", Map.of(
                        "customer_id", customerId,
                        "provider_code", providerCode,
                        "country_code", countryCode
                )
        );
        return saltEdgeService.post("/connections", requestBody, new ParameterizedTypeReference<SaltEdgeSingleResponse<Connection>>() {})
                .map(SaltEdgeSingleResponse::getData);
    }

    public Mono<Connection> updateConnection(String connectionId, Map<String, Object> attributes) {
        Map<String, Object> requestBody = Map.of("data", attributes);
        return saltEdgeService.put("/connections/" + connectionId, requestBody, new ParameterizedTypeReference<SaltEdgeSingleResponse<Connection>>() {})
                .map(SaltEdgeSingleResponse::getData);
    }

    public Mono<Void> deleteConnection(String connectionId) {
        return saltEdgeService.delete("/connections/" + connectionId, Void.class);
    }

    public Mono<Connection> refreshConnection(String connectionId) {
        return saltEdgeService.put("/connections/" + connectionId + "/refresh", Map.of(), new ParameterizedTypeReference<SaltEdgeSingleResponse<Connection>>() {})
                .map(SaltEdgeSingleResponse::getData);
    }

    public Mono<Connection> reconnectConnection(String connectionId) {
        return saltEdgeService.put("/connections/" + connectionId + "/reconnect", Map.of(), new ParameterizedTypeReference<SaltEdgeSingleResponse<Connection>>() {})
                .map(SaltEdgeSingleResponse::getData);
    }
} 