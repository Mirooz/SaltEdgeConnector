package com.saltedge.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Transaction {
    @JsonProperty("id")
    private String id;

    @JsonProperty("account_id")
    private String accountId;

    @JsonProperty("duplicated")
    private boolean duplicated;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("status")
    private String status;

    @JsonProperty("made_on")
    private LocalDate madeOn;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("description")
    private String description;

    @JsonProperty("category")
    private String category;

    @JsonProperty("extra")
    private Extra extra;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @Data
    public static class Extra {
        @JsonProperty("id")
        private String id;
        @JsonProperty("account_number")
        private String accountNumber;

        @JsonProperty("transfer_account_name")
        private String transferAccountName;

        @JsonProperty("additional")
        private String additional;

        @JsonProperty("account_balance_snapshot")
        private BigDecimal accountBalanceSnapshot;

        @JsonProperty("categorization_confidence")
        private String categorizationConfidence;
    }
} 