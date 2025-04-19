package com.saltedge.connector.client;

import com.saltedge.connector.model.Account;
import com.saltedge.connector.model.Customer;
import com.saltedge.connector.model.Provider;
import com.saltedge.connector.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Map;

public interface SaltEdgeClient {
    // Provider operations
    /**
     * Récupère tous les providers disponibles
     * @return Un Flux de providers
     */
    Flux<Provider> getAllProviders();

    Flux<Provider> getProviders(Map<String, Object> queryParams);



    // Customer operations

    Mono<Provider> getProvider(String providerCode);

    /**
     * Crée un nouveau client
     * @param identifier L'identifiant du client
     * @return Un Mono contenant le client créé
     */
    Mono<Customer> createCustomer(String identifier);

    /**
     * Récupère un client par son ID
     * @param customerId L'identifiant du client
     * @param queryParams Paramètres optionnels de requête
     * @return Un Mono contenant le client
     */
    Mono<Customer> getCustomer(String customerId, Map<String, Object> queryParams);

    /**
     * Récupère tous les clients
     * @param queryParams Paramètres optionnels de requête
     * @return Un Flux de clients
     */
    Flux<Customer> getAllCustomers(Map<String, Object> queryParams);

    /**
     * Supprime un client
     * @param customerId L'identifiant du client
     * @return Un Mono vide
     */
    Mono<Void> deleteCustomer(String customerId);

    /**
     * Met à jour les attributs d'un client
     * @param customerId L'identifiant du client
     * @param attributes Les attributs à mettre à jour
     * @return Un Mono contenant le client mis à jour
     */
    Mono<Customer> updateCustomer(String customerId, Map<String, Object> attributes);

    // Account operations
    /**
     * Récupère un compte par son ID
     * @param accountId L'identifiant du compte
     * @param queryParams Paramètres optionnels de requête
     * @return Un Mono contenant le compte
     */
    Mono<Account> getAccount(String accountId, Map<String, Object> queryParams);

    /**
     * Récupère tous les comptes avec les paramètres spécifiés
     * @param queryParams Paramètres de requête (connection_id, customer_id, etc.)
     * @return Un Flux de comptes
     */
    Flux<Account> getAccounts(Map<String, Object> queryParams);

    /**
     * Met à jour les attributs d'un compte
     * @param accountId L'identifiant du compte
     * @param attributes Les attributs à mettre à jour
     * @return Un Mono contenant le compte mis à jour
     */
    Mono<Account> updateAccount(String accountId, Map<String, Object> attributes);

    /**
     * Supprime un compte
     * @param accountId L'identifiant du compte
     * @return Un Mono vide
     */
    Mono<Void> deleteAccount(String accountId);

    // Transaction operations
    /**
     * Récupère une transaction par son ID
     * @param transactionId L'identifiant de la transaction
     * @param queryParams Paramètres optionnels de requête
     * @return Un Mono contenant la transaction
     */
    Mono<Transaction> getTransaction(String transactionId, Map<String, Object> queryParams);

    /**
     * Récupère les transactions selon les paramètres spécifiés
     * @param queryParams Paramètres de requête (connection_id, account_id, customer_id, from_date, to_date, etc.)
     * @return Un Flux de transactions
     */
    Flux<Transaction> getTransactions(Map<String, Object> queryParams);

    /**
     * Met à jour les attributs d'une transaction
     * @param transactionId L'identifiant de la transaction
     * @param attributes Les attributs à mettre à jour
     * @return Un Mono contenant la transaction mise à jour
     */
    Mono<Transaction> updateTransaction(String transactionId, Map<String, Object> attributes);

    /**
     * Supprime une transaction
     * @param transactionId L'identifiant de la transaction
     * @return Un Mono vide
     */
    Mono<Void> deleteTransaction(String transactionId);
} 