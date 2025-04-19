package com.saltedge.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class Customers {
    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("identifier")
    private String identifier;

    @JsonProperty("categorization_type")
    private String categorizationType;

    @JsonProperty("blocked_at")
    private Instant blockedAt;

    @JsonProperty("created_at")
    private Instant createdAt;

    @JsonProperty("updated_at")
    private Instant updatedAt;

    @JsonProperty("deleted")
    private boolean deleted ;
} 