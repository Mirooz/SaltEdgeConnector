package com.saltedge.connector.client;

import com.saltedge.connector.model.Account;
import com.saltedge.connector.model.Customer;
import com.saltedge.connector.model.Provider;
import com.saltedge.connector.model.Transaction;
import com.saltedge.connector.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.LocalDate;
import java.util.Map;
import java.util.function.Function;

@Component
public class SaltEdgeClientImpl implements SaltEdgeClient {
    private final WebClient webClient;
    @Autowired
    private final ProviderService providerService;

    public SaltEdgeClientImpl(
            @Value("${saltedge.api.base-url}") String baseUrl,
            @Value("${saltedge.api.app-id}") String appId,
            @Value("${saltedge.api.secret}") String secret, ProviderService providerService) {
        this.providerService = providerService;
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("App-id", appId)
                .defaultHeader("Secret", secret)
                .build();
    }

    private Function<UriBuilder, URI> buildUri(String path, Map<String, Object> queryParams) {
        return uriBuilder -> {
            UriBuilder builder = uriBuilder.path(path);
            if (queryParams != null) {
                queryParams.forEach((key, value) -> {
                    if (value != null) {
                        builder.queryParam(key, value.toString());
                    }
                });
            }
            return builder.build();
        };
    }

    // Provider operations
    @Override
    public Flux<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }
    @Override
    public Flux<Provider> getProviders(Map<String, Object> queryParams) {
        return providerService.getProviders(queryParams);
    }


    @Override
    public Mono<Provider> getProvider(String providerCode) {
        return providerService.getProvider(providerCode);
    }

    @Override
    public Mono<Customer> createCustomer(String identifier) {
        return null;
    }

    @Override
    public Mono<Customer> getCustomer(String customerId) {
        return null;
    }

    @Override
    public Flux<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public Mono<Void> deleteCustomer(String customerId) {
        return null;
    }

    @Override
    public Mono<Customer> updateCustomer(String customerId, Map<String, Object> attributes) {
        return null;
    }

    @Override
    public Mono<Account> getAccount(String accountId) {
        return null;
    }

    @Override
    public Flux<Account> getAccountsByConnection(String connectionId) {
        return null;
    }

    @Override
    public Flux<Account> getAccountsByCustomer(String customerId) {
        return null;
    }

    @Override
    public Mono<Account> updateAccount(String accountId, Map<String, Object> attributes) {
        return null;
    }

    @Override
    public Mono<Void> deleteAccount(String accountId) {
        return null;
    }

    @Override
    public Mono<Transaction> getTransaction(String transactionId) {
        return null;
    }

    @Override
    public Flux<Transaction> getTransactionsByAccount(String accountId, LocalDate fromDate, LocalDate toDate) {
        return null;
    }

    @Override
    public Flux<Transaction> getTransactionsByConnection(String connectionId, LocalDate fromDate, LocalDate toDate) {
        return null;
    }

    @Override
    public Flux<Transaction> getTransactionsByCustomer(String customerId, LocalDate fromDate, LocalDate toDate) {
        return null;
    }

    @Override
    public Mono<Transaction> updateTransaction(String transactionId, Map<String, Object> attributes) {
        return null;
    }

    @Override
    public Mono<Void> deleteTransaction(String transactionId) {
        return null;
    }

    // Customer operations

} 