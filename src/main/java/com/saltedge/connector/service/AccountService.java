package com.saltedge.connector.service;

import com.saltedge.connector.model.Account;
import com.saltedge.connector.model.response.SaltEdgeResponse;
import com.saltedge.connector.model.response.SaltEdgeSingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class AccountService {

    private final SaltEdgeService saltEdgeService;

    @Autowired
    public AccountService(SaltEdgeService saltEdgeService) {
        this.saltEdgeService = saltEdgeService;
    }

    public Flux<Account> getAccountWithConnectionId(String connectionId) {
        Map<String,Object> param = Map.of(
                "connection_id",connectionId);
        return saltEdgeService.get("/accounts", new ParameterizedTypeReference<SaltEdgeResponse<Account>>() {},param)
                .flatMapMany(response -> Flux.fromIterable(response.getData()));
    }

    public Flux<Account> getAccountWithCustomerId(String customerId) {
        Map<String,Object> param = Map.of(
                "customer_id",customerId);
        return saltEdgeService.get("/accounts", new ParameterizedTypeReference<SaltEdgeResponse<Account>>() {},param)
                .flatMapMany(response -> Flux.fromIterable(response.getData()));
    }
} 