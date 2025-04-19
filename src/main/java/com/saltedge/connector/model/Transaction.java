package com.saltedge.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class Transaction {
    private String id;
    private String mode;
    private String status;
    private String madeOn;
    private String amount;
    private String currencyCode;
    private String description;
    private String category;
    private String duplicate;
    
    @JsonProperty("account_id")
    private String accountId;
    
    @JsonProperty("connection_id")
    private String connectionId;
    
    @JsonProperty("customer_id")
    private String customerId;
    
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    
    @JsonProperty("posting_date")
    private String postingDate;
    
    @JsonProperty("booking_date")
    private String bookingDate;
    
    @JsonProperty("value_date")
    private String valueDate;
    
    @JsonProperty("original_amount")
    private String originalAmount;
    
    @JsonProperty("original_currency_code")
    private String originalCurrencyCode;
    
    @JsonProperty("converted_amount")
    private String convertedAmount;
    
    @JsonProperty("converted_currency_code")
    private String convertedCurrencyCode;
    
    @JsonProperty("balance")
    private String balance;
    
    @JsonProperty("account_balance_snapshot")
    private String accountBalanceSnapshot;
    
    @JsonProperty("extra")
    private Map<String, Object> extra;
    
    @JsonProperty("merchant")
    private Merchant merchant;
    
    @JsonProperty("tags")
    private String[] tags;
    
    @Data
    public static class Merchant {
        private String name;
        private String website;
        private String logo;
        private String category;
        private String categoryCode;
        private String address;
        private String city;
        private String state;
        private String country;
        private String postalCode;
        private String phone;
        private String email;
    }
} 