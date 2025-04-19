package com.saltedge.connector.service;

import com.saltedge.connector.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Mono<Customer> createCustomer(String identifier) {
        Map<String, Object> requestBody = Map.of("identifier", identifier);
        return saltEdgeService.post("/customers", requestBody, Customer.class);
    }

    public Mono<Customer> getCustomer(String customerId) {
        return saltEdgeService.get("/customers/" + customerId, Customer.class);
    }

    public Flux<Customer> getAllCustomers() {
        return saltEdgeService.get("/customers", Customer[].class)
                .flatMapMany(Flux::fromArray);
    }

    public Mono<Void> deleteCustomer(String customerId) {
        return saltEdgeService.delete("/customers/" + customerId, Void.class);
    }

    public Mono<Customer> updateCustomer(String customerId, Map<String, Object> attributes) {
        return saltEdgeService.put("/customers/" + customerId, attributes, Customer.class);
    }
} 