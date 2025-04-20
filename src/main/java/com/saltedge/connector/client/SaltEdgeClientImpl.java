package com.saltedge.connector.client;

import com.saltedge.connector.model.*;
import com.saltedge.connector.service.AccountService;
import com.saltedge.connector.service.ConnectionService;
import com.saltedge.connector.service.CustomerService;
import com.saltedge.connector.service.ProviderService;
import com.saltedge.connector.service.TransactionService;
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
import java.util.Map;
import java.util.function.Function;

@Component
public class SaltEdgeClientImpl implements SaltEdgeClient {
    private final ProviderService providerService;
    private final CustomerService customerService;
    private final ConnectionService connectionService;
    private final AccountService accountService;
    private final TransactionService transactionService;

    @Autowired
    public SaltEdgeClientImpl(
            ProviderService providerService,
            CustomerService customerService,
            ConnectionService connectionService,
            AccountService accountService,
            TransactionService transactionService) {
        this.providerService = providerService;
        this.customerService = customerService;
        this.connectionService = connectionService;
        this.accountService = accountService;
        this.transactionService = transactionService;
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
    public Mono<Customers> createCustomer(String identifier) {
        return customerService.createCustomer(identifier);
    }

    @Override
    public Mono<Customers> getCustomer(String customerId) {
        return customerService.getCustomer(customerId);
    }

    @Override
    public Flux<Customers> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @Override
    public Mono<Customers> deleteCustomer(String customerId) {
        return customerService.deleteCustomer(customerId);
    }

    @Override
    public Mono<Customers> updateCustomer(String customerId, Map<String, Object> attributes) {
        return customerService.updateCustomer(customerId,attributes);
    }


    @Override
    public Mono<Connection> getConnectionWithConnectionId(String connectionId) {
        return connectionService.getConnectionWithConnectionId(connectionId);
    }

    @Override
    public Mono<Connection> getConnectionWithCustomerId(String customerId) {
        return connectionService.getConnectionWithCustomerId(customerId);
    }

    @Override
    public Mono<ConnectionCreated> createConnection(String customerId, String returnToUrl) {
        return connectionService.createConnection(customerId, returnToUrl);
    }

    @Override
    public Mono<Connection> updateConnection(String connectionId, Map<String, Object> attributes) {
        return connectionService.updateConnection(connectionId, attributes);
    }

    @Override
    public Mono<Connection> deleteConnection(String connectionId) {
        return connectionService.deleteConnection(connectionId);
    }

    @Override
    public Mono<Connection> refreshConnection(String connectionId, String returnToUrl) {
        return connectionService.refreshConnection(connectionId, returnToUrl);
    }


    @Override
    public Flux<Account> getAccountWithConnectionId(String connectionId) {
        return accountService.getAccountWithConnectionId(connectionId);
    }

    @Override
    public Flux<Account> getAccountWithCustomerId(String customerId) {
        return accountService.getAccountWithCustomerId(customerId);
    }


    @Override
    public Flux<Transaction> getTransactionsByConnection(String connectionId) {
        return transactionService.getTransactionsByConnection(connectionId);
    }




} 