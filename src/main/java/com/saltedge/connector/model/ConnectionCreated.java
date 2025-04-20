package com.saltedge.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ConnectionCreated {
    @JsonProperty("expires_at")
    private String expiresAt;

    @JsonProperty("connect_url")
    private String connectUrl;

    @JsonProperty("customer_id")
    private String customerId;
}
