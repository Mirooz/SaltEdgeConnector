package com.saltedge.connector.service;

import com.saltedge.connector.model.Connection;
import com.saltedge.connector.model.ConnectionCreated;
import com.saltedge.connector.model.response.SaltEdgeResponse;
import com.saltedge.connector.model.response.SaltEdgeSingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.List;

@Service
public class ConnectionService {

    private final SaltEdgeService saltEdgeService;

    @Autowired
    public ConnectionService(SaltEdgeService saltEdgeService) {
        this.saltEdgeService = saltEdgeService;
    }


    public Mono<Connection> getConnectionWithConnectionId(String connectionId) {
        return saltEdgeService.get("/connections/" + connectionId, new ParameterizedTypeReference<SaltEdgeSingleResponse<Connection>>() {})
                .map(SaltEdgeSingleResponse::getData);
    }

    public Mono<Connection> getConnectionWithCustomerId(String customerId) {
        Map<String, Object> param = Map.of("customer_id",customerId);
        return saltEdgeService.get("/connections", new ParameterizedTypeReference<SaltEdgeSingleResponse<Connection>>() {},param)
                .map(SaltEdgeSingleResponse::getData);
    }

    public Mono<ConnectionCreated> createConnection(String customerId, String returnToUrl) {
        Map<String, Object> requestBody = Map.of(
                "data", Map.of(
                        "customer_id", customerId,
                        "consent", Map.of(
                                "scopes", List.of("accounts", "transactions", "holder_info")
                        ),
                        "attempt", Map.of(
                                "fetch_scopes", List.of("accounts", "balance", "transactions", "holder_info"),
                                "return_to", returnToUrl
                        ),
                        "widget", Map.of(),
                        "provider", Map.of(),
                        "automatic_refresh", true
                )
        );
        return saltEdgeService.post("/connections/connect", requestBody, new ParameterizedTypeReference<SaltEdgeSingleResponse<ConnectionCreated>>() {})
                .map(SaltEdgeSingleResponse::getData);
    }

    public Mono<Connection> updateConnection(String connectionId, Map<String, Object> attributes) {
        Map<String, Object> requestBody = Map.of(
                "data", Map.of(
                        "automatic_refresh", attributes.getOrDefault("automatic_refresh", true),
                        "categorization", attributes.getOrDefault("categorization", "business"),
                        "categorization_vendor", attributes.getOrDefault("categorization_vendor", "saltedge"),
                        "status", attributes.getOrDefault("status", "inactive"),
                        "store_credentials", attributes.getOrDefault("store_credentials", false)
                )
        );
        return saltEdgeService.put("/connections/" + connectionId, requestBody, new ParameterizedTypeReference<SaltEdgeSingleResponse<Connection>>() {})
                .map(SaltEdgeSingleResponse::getData);
    }

    public Mono<Connection> deleteConnection(String connectionId) {
        return saltEdgeService.delete("/connections/" + connectionId, new ParameterizedTypeReference<SaltEdgeSingleResponse<Connection>>() {})
                .map(SaltEdgeSingleResponse::getData);
    }

    public Mono<Connection> refreshConnection(String connectionId, String returnToUrl) {
        Map<String, Object> requestBody = Map.of(
                "data", Map.of(
                        "attempt", Map.of(
                                "return_to", returnToUrl
                        )
                )
        );
        return saltEdgeService.put("/connections/" + connectionId + "/refresh", requestBody, new ParameterizedTypeReference<SaltEdgeSingleResponse<Connection>>() {})
                .map(SaltEdgeSingleResponse::getData);
    }
} 