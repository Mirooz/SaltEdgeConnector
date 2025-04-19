package com.saltedge.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class Account {
    private String id;
    private String name;
    private String nature;
    private String balance;
    private String currencyCode;
    private String status;
    
    @JsonProperty("connection_id")
    private String connectionId;
    
    @JsonProperty("customer_id")
    private String customerId;
    
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    
    @JsonProperty("extra")
    private Map<String, Object> extra;
    
    @JsonProperty("account_number")
    private String accountNumber;
    
    @JsonProperty("iban")
    private String iban;
    
    @JsonProperty("swift")
    private String swift;
    
    @JsonProperty("sort_code")
    private String sortCode;
    
    @JsonProperty("bic")
    private String bic;
    
    @JsonProperty("client_name")
    private String clientName;
    
    @JsonProperty("available_amount")
    private String availableAmount;
    
    @JsonProperty("credit_limit")
    private String creditLimit;
    
    @JsonProperty("interest_rate")
    private String interestRate;
    
    @JsonProperty("next_payment_amount")
    private String nextPaymentAmount;
    
    @JsonProperty("next_payment_date")
    private LocalDateTime nextPaymentDate;
    
    @JsonProperty("opening_balance")
    private String openingBalance;
    
    @JsonProperty("closing_balance")
    private String closingBalance;
    
    @JsonProperty("transactions_count")
    private Integer transactionsCount;
    
    @JsonProperty("last_successful_update")
    private LocalDateTime lastSuccessfulUpdate;
    
    @JsonProperty("last_failed_update")
    private LocalDateTime lastFailedUpdate;
    
    @JsonProperty("next_refresh_possible_at")
    private LocalDateTime nextRefreshPossibleAt;
} 