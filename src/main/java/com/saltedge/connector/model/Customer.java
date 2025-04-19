package com.saltedge.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Customer {
    private String id;
    private String identifier;
    private String secret;
    private String status;
    
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    
    @JsonProperty("last_accessed_at")
    private LocalDateTime lastAccessedAt;
    
    @JsonProperty("consent_given_at")
    private LocalDateTime consentGivenAt;
    
    @JsonProperty("consent_withdrawn_at")
    private LocalDateTime consentWithdrawnAt;
    
    @JsonProperty("consent_expires_at")
    private LocalDateTime consentExpiresAt;
    
    @JsonProperty("consent_required")
    private boolean consentRequired;
    
    @JsonProperty("consent_given")
    private boolean consentGiven;
    
    @JsonProperty("consent_withdrawn")
    private boolean consentWithdrawn;
    
    @JsonProperty("consent_expired")
    private boolean consentExpired;
    
    @JsonProperty("consent_valid_until")
    private LocalDateTime consentValidUntil;
    
    @JsonProperty("consent_valid_for_days")
    private Integer consentValidForDays;
    
    @JsonProperty("consent_scopes")
    private String[] consentScopes;
    
    @JsonProperty("consent_shared_data")
    private String[] consentSharedData;
    
    @JsonProperty("consent_shared_data_expires_at")
    private LocalDateTime consentSharedDataExpiresAt;
    
    @JsonProperty("consent_shared_data_valid_until")
    private LocalDateTime consentSharedDataValidUntil;
    
    @JsonProperty("consent_shared_data_valid_for_days")
    private Integer consentSharedDataValidForDays;
    
    @JsonProperty("consent_shared_data_scopes")
    private String[] consentSharedDataScopes;
    
    @JsonProperty("consent_shared_data_shared_data")
    private String[] consentSharedDataSharedData;
} 