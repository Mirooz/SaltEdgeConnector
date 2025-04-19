package com.saltedge.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Connection {
    private String id;
    
    @JsonProperty("customer_id")
    private String customerId;
    
    @JsonProperty("provider_id")
    private String providerId;
    
    @JsonProperty("provider_code")
    private String providerCode;
    
    @JsonProperty("provider_name")
    private String providerName;
    
    private String status;
    
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    
    @JsonProperty("last_success_at")
    private LocalDateTime lastSuccessAt;
    
    @JsonProperty("last_fail_at")
    private LocalDateTime lastFailAt;
    
    @JsonProperty("next_refresh_possible_at")
    private LocalDateTime nextRefreshPossibleAt;
    
    @JsonProperty("store_credentials")
    private boolean storeCredentials;
    
    @JsonProperty("show_consent_confirmation")
    private boolean showConsentConfirmation;
    
    @JsonProperty("last_attempt")
    private LastAttempt lastAttempt;
    
    @Data
    public static class LastAttempt {
        private String status;
        private String message;
        private String stage;
        private LocalDateTime createdAt;
    }
} 