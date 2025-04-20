package com.saltedge.connector.client;

import com.saltedge.connector.model.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Map;

public interface SaltEdgeClient {
    // Provider operations
    /**
     * Retrieves all available providers
     * @return A Flux of providers
     */
    Flux<Provider> getAllProviders();

    Flux<Provider> getProviders(Map<String, Object> queryParams);

    /**
     * Retrieves a provider by its code
     * @param providerCode The provider code
     * @return A Mono containing the provider
     */
    Mono<Provider> getProvider(String providerCode);

    // Customers operations
    /**
     * Creates a new Customers
     * @param identifier The Customers identifier
     * @return A Mono containing the created Customers
     */
    Mono<Customers> createCustomer(String identifier);

    /**
     * Retrieves a Customers by its ID
     * @param customerId The Customers ID
     * @return A Mono containing the Customers
     */
    Mono<Customers> getCustomer(String customerId);

    /**
     * Retrieves all Customerss
     * @return A Flux of Customerss
     */
    Flux<Customers> getAllCustomers();

    /**
     * Deletes a Customers
     * @param customerId The Customers ID
     * @return An empty Mono
     */
    Mono<Customers> deleteCustomer(String customerId);

    /**
     * Updates a Customers's attributes
     * @param customerId The Customers ID
     * @param attributes The attributes to update
     * @return A Mono containing the updated Customers
     */
    Mono<Customers> updateCustomer(String customerId, Map<String, Object> attributes);

    // Connection operations

    /**
     * Retrieves a connection by its ID
     * @param connectionId The connection ID
     * @return A Mono containing the connection
     */
    Mono<Connection> getConnectionWithConnectionId(String connectionId);

    /**
     * Retrieves a connection by its ID with query parameters
     * @param connectionId The connection ID
     * @param queryParams The query parameters
     * @return A Mono containing the connection
     */
    Mono<Connection> getConnectionWithCustomerId(String customerId);

    /**
     * Creates a new connection
     * @param customerId The Customers ID
     * @param returnToUrl The URL to return to after the connection process
     * @return A Mono containing the created connection
     */
    Mono<ConnectionCreated> createConnection(String customerId, String returnToUrl);

    /**
     * Updates a connection's attributes
     * @param connectionId The connection ID
     * @param attributes The attributes to update
     * @return A Mono containing the updated connection
     */
    Mono<Connection> updateConnection(String connectionId, Map<String, Object> attributes);

    /**
     * Deletes a connection
     * @param connectionId The connection ID
     * @return A Mono containing the deleted connection
     */
    Mono<Connection> deleteConnection(String connectionId);

    /**
     * Refreshes a connection
     * @param connectionId The connection ID
     * @param returnToUrl The URL to return to after the refresh process
     * @return A Mono containing the refreshed connection
     */
    Mono<Connection> refreshConnection(String connectionId, String returnToUrl);

    // Account operations

    Flux<Account> getAccountWithConnectionId(String connectionId);

    Flux<Account> getAccountWithCustomerId(String customerId);


    // Transaction operations
    Flux<Transaction> getTransactionsByConnection(String connectionId);
}