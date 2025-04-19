package com.saltedge.connector.service;
import com.saltedge.connector.model.Customers;
import com.saltedge.connector.model.response.SaltEdgeResponse;
import com.saltedge.connector.model.response.SaltEdgeSingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class CustomerService {

    private final SaltEdgeService saltEdgeService;

    @Autowired
    public CustomerService(SaltEdgeService saltEdgeService) {
        this.saltEdgeService = saltEdgeService;
    }

    public Flux<Customers> getAllCustomers() {
        return saltEdgeService.get("/customers", new ParameterizedTypeReference<SaltEdgeResponse<Customers>>() {})
                .flatMapMany(response -> Flux.fromIterable(response.getData()));
    }

    public Mono<Customers> getCustomer(String customerId) {
        return saltEdgeService.get("/customers/" + customerId, new ParameterizedTypeReference<SaltEdgeSingleResponse<Customers>>() {})
                .map(SaltEdgeSingleResponse::getData);
    }

    public Mono<Customers> createCustomer(String identifier) {
        Map<String, Object> requestBody = Map.of(
                "data", Map.of("identifier", identifier)
        );
        return saltEdgeService.post("/customers", requestBody, new ParameterizedTypeReference<SaltEdgeSingleResponse<Customers>>() {})
                .map(SaltEdgeSingleResponse::getData);
    }

    public Mono<Customers> updateCustomer(String customerId, Map<String, Object> attributes) {
        return saltEdgeService.put("/customers/" + customerId, attributes, new ParameterizedTypeReference<SaltEdgeSingleResponse<Customers>>() {})
                .map(SaltEdgeSingleResponse::getData);
    }

    public Mono<Customers> deleteCustomer(String customerId) {
        return saltEdgeService.delete("/customers/" + customerId,new ParameterizedTypeReference<SaltEdgeSingleResponse<Customers>>() {})
                .map(SaltEdgeSingleResponse::getData);
    }
} 