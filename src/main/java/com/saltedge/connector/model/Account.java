package com.saltedge.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class Account {
    @JsonProperty("id")
    private String id;

    @JsonProperty("connection_id")
    private String connectionId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("nature")
    private String nature;

    @JsonProperty("balance")
    private BigDecimal balance;

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("extra")
    private Extra extra;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @Data
    public static class Extra {
        @JsonProperty("bban")
        private String bban;

        @JsonProperty("iban")
        private String iban;

        @JsonProperty("sort_code")
        private String sortCode;

        @JsonProperty("holder_name")
        private String holderName;

        @JsonProperty("transactions_count")
        private TransactionsCount transactionsCount;

        @JsonProperty("provider_account_id")
        private String providerAccountId;

        @JsonProperty("last_posted_transaction_id")
        private String lastPostedTransactionId;
    }

    @Data
    public static class TransactionsCount {
        @JsonProperty("posted")
        private int posted;

        @JsonProperty("pending")
        private int pending;
    }
} 