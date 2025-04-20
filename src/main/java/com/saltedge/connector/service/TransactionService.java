package com.saltedge.connector.service;

import com.saltedge.connector.model.Transaction;
import com.saltedge.connector.model.response.SaltEdgeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
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
    public Flux<Transaction> getTransactionsByConnection(String connectionId) {
        Map<String, Object> params = Map.of("connection_id", connectionId);

        return saltEdgeService.get("/transactions", new ParameterizedTypeReference<SaltEdgeResponse<Transaction>>() {}, params)
                .flatMapMany(response -> Flux.fromIterable(response.getData()));
    }
} 