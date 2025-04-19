package com.saltedge.connector.service;

import com.saltedge.connector.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Map;

@Service
public class TransactionService {

    private final SaltEdgeService saltEdgeService;

    @Autowired
    public TransactionService(SaltEdgeService saltEdgeService) {
        this.saltEdgeService = saltEdgeService;
    }

    public Mono<Transaction> getTransaction(String transactionId) {
        return saltEdgeService.get("/transactions/" + transactionId, Transaction.class);
    }

    public Flux<Transaction> getTransactionsByAccount(String accountId, LocalDate fromDate, LocalDate toDate) {
        String endpoint = String.format("/transactions?account_id=%s&from_date=%s&to_date=%s",
                accountId, fromDate, toDate);
        return saltEdgeService.get(endpoint, Transaction[].class)
                .flatMapMany(Flux::fromArray);
    }

    public Flux<Transaction> getTransactionsByConnection(String connectionId, LocalDate fromDate, LocalDate toDate) {
        String endpoint = String.format("/transactions?connection_id=%s&from_date=%s&to_date=%s",
                connectionId, fromDate, toDate);
        return saltEdgeService.get(endpoint, Transaction[].class)
                .flatMapMany(Flux::fromArray);
    }

    public Flux<Transaction> getTransactionsByCustomer(String customerId, LocalDate fromDate, LocalDate toDate) {
        String endpoint = String.format("/transactions?customer_id=%s&from_date=%s&to_date=%s",
                customerId, fromDate, toDate);
        return saltEdgeService.get(endpoint, Transaction[].class)
                .flatMapMany(Flux::fromArray);
    }

    public Mono<Transaction> updateTransaction(String transactionId, Map<String, Object> attributes) {
        return saltEdgeService.put("/transactions/" + transactionId, attributes, Transaction.class);
    }

    public Mono<Void> deleteTransaction(String transactionId) {
        return saltEdgeService.delete("/transactions/" + transactionId, Void.class);
    }
} 