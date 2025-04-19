package com.saltedge.connector.service;

import com.saltedge.connector.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Mono<Account> getAccount(String accountId) {
        return saltEdgeService.get("/accounts/" + accountId, Account.class);
    }

    public Flux<Account> getAccountsByConnection(String connectionId) {
        return saltEdgeService.get("/accounts?connection_id=" + connectionId, Account[].class)
                .flatMapMany(Flux::fromArray);
    }

    public Flux<Account> getAccountsByCustomer(String customerId) {
        return saltEdgeService.get("/accounts?customer_id=" + customerId, Account[].class)
                .flatMapMany(Flux::fromArray);
    }

    public Mono<Account> updateAccount(String accountId, Map<String, Object> attributes) {
        return saltEdgeService.put("/accounts/" + accountId, attributes, Account.class);
    }

    public Mono<Void> deleteAccount(String accountId) {
        return saltEdgeService.delete("/accounts/" + accountId, Void.class);
    }
} 