package com.saltedge.connector.service;

import com.saltedge.connector.model.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class ConnectionService {

    private final SaltEdgeService saltEdgeService;

    @Autowired
    public ConnectionService(SaltEdgeService saltEdgeService) {
        this.saltEdgeService = saltEdgeService;
    }

    public Mono<Connection> createConnection(String customerId, String providerCode, Map<String, Object> credentials) {
        Map<String, Object> requestBody = Map.of(
                "customer_id", customerId,
                "provider_code", providerCode,
                "credentials", credentials
        );
        return saltEdgeService.post("/connections", requestBody, Connection.class);
    }

    public Mono<Connection> getConnection(String connectionId) {
        return saltEdgeService.get("/connections/" + connectionId, Connection.class);
    }

    public Mono<Connection> updateConnection(String connectionId, Map<String, Object> credentials) {
        Map<String, Object> requestBody = Map.of("credentials", credentials);
        return saltEdgeService.put("/connections/" + connectionId, requestBody, Connection.class);
    }

    public Mono<Void> deleteConnection(String connectionId) {
        return saltEdgeService.delete("/connections/" + connectionId, Void.class);
    }

    public Mono<Connection> refreshConnection(String connectionId) {
        return saltEdgeService.put("/connections/" + connectionId + "/refresh", null, Connection.class);
    }
} 