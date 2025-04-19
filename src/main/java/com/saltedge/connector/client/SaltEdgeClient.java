package com.saltedge.connector.client;

import com.saltedge.connector.model.Account;
import com.saltedge.connector.model.Customers;
import com.saltedge.connector.model.Provider;
import com.saltedge.connector.model.Transaction;
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

    // Customer operations
    /**
     * Creates a new customer
     * @param identifier The customer identifier
     * @return A Mono containing the created customer
     */
    Mono<Customers> createCustomer(String identifier);

    /**
     * Retrieves a customer by its ID
     * @param customerId The customer ID
     * @return A Mono containing the customer
     */
    Mono<Customers> getCustomer(String customerId);

    /**
     * Retrieves all customers
     * @return A Flux of customers
     */
    Flux<Customers> getAllCustomers();

    /**
     * Deletes a customer
     * @param customerId The customer ID
     * @return An empty Mono
     */
    Mono<Customers> deleteCustomer(String customerId);

    /**
     * Updates a customer's attributes
     * @param customerId The customer ID
     * @param attributes The attributes to update
     * @return A Mono containing the updated customer
     */
    Mono<Customers> updateCustomer(String customerId, Map<String, Object> attributes);

    // Account operations
    /**
     * Retrieves an account by its ID
     * @param accountId The account ID
     * @return A Mono containing the account
     */
    Mono<Account> getAccount(String accountId);

    /**
     * Retrieves all accounts for a connection
     * @param connectionId The connection ID
     * @return A Flux of accounts
     */
    Flux<Account> getAccountsByConnection(String connectionId);

    /**
     * Retrieves all accounts for a customer
     * @param customerId The customer ID
     * @return A Flux of accounts
     */
    Flux<Account> getAccountsByCustomer(String customerId);

    /**
     * Updates an account's attributes
     * @param accountId The account ID
     * @param attributes The attributes to update
     * @return A Mono containing the updated account
     */
    Mono<Account> updateAccount(String accountId, Map<String, Object> attributes);

    /**
     * Deletes an account
     * @param accountId The account ID
     * @return An empty Mono
     */
    Mono<Void> deleteAccount(String accountId);

    // Transaction operations
    /**
     * Retrieves a transaction by its ID
     * @param transactionId The transaction ID
     * @return A Mono containing the transaction
     */
    Mono<Transaction> getTransaction(String transactionId);

    /**
     * Retrieves transactions for an account within a date range
     * @param accountId The account ID
     * @param fromDate The start date
     * @param toDate The end date
     * @return A Flux of transactions
     */
    Flux<Transaction> getTransactionsByAccount(String accountId, LocalDate fromDate, LocalDate toDate);

    /**
     * Retrieves transactions for a connection within a date range
     * @param connectionId The connection ID
     * @param fromDate The start date
     * @param toDate The end date
     * @return A Flux of transactions
     */
    Flux<Transaction> getTransactionsByConnection(String connectionId, LocalDate fromDate, LocalDate toDate);

    /**
     * Retrieves transactions for a customer within a date range
     * @param customerId The customer ID
     * @param fromDate The start date
     * @param toDate The end date
     * @return A Flux of transactions
     */
    Flux<Transaction> getTransactionsByCustomer(String customerId, LocalDate fromDate, LocalDate toDate);

    /**
     * Updates a transaction's attributes
     * @param transactionId The transaction ID
     * @param attributes The attributes to update
     * @return A Mono containing the updated transaction
     */
    Mono<Transaction> updateTransaction(String transactionId, Map<String, Object> attributes);

    /**
     * Deletes a transaction
     * @param transactionId The transaction ID
     * @return An empty Mono
     */
    Mono<Void> deleteTransaction(String transactionId);
} 