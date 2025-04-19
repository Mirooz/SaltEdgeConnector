package com.saltedge.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Provider {
    private String id;
    private String code;
    private String name;
    private String mode;
    private String status;
    private String[] products;

    @JsonProperty("automatic_fetch")
    private boolean automaticFetch;

    @JsonProperty("max_consent_days")
    private Integer maxConsentDays;

    @JsonProperty("max_interactive_delay")
    private Integer maxInteractiveDelay;

    @JsonProperty("timezone_offset")
    private String timezoneOffset;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("max_fetch_interval")
    private Integer maxFetchInterval;

    @JsonProperty("payment_templates")
    private List<Map<String, Object>> paymentTemplates;

    @JsonProperty("payment_fields")
    private List<Map<String, Object>> paymentFields;

    @JsonProperty("payment_products")
    private List<Map<String, Object>> paymentProducts;

    @JsonProperty("identification_mode")
    private String identificationMode;

    @JsonProperty("identification_fields")
    private List<Map<String, Object>> identificationFields;

    @JsonProperty("regulated")
    private boolean regulated;

    @JsonProperty("regulated_by")
    private String regulatedBy;

    @JsonProperty("regulated_jurisdiction")
    private String regulatedJurisdiction;

    @JsonProperty("regulated_number")
    private String regulatedNumber;

    @JsonProperty("regulated_url")
    private String regulatedUrl;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("refresh_timeout")
    private Integer refreshTimeout;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("required_fields")
    private List<Map<String, Object>> requiredFields;

    @JsonProperty("interactive_fields")
    private List<Map<String, Object>> interactiveFields;

    @JsonProperty("optional_fields")
    private List<Map<String, Object>> optionalFields;

    @JsonProperty("include_fake_providers")
    private boolean includeFakeProviders;

    @JsonProperty("customer_notified_on_sign_in")
    private boolean customerNotifiedOnSignIn;

    @JsonProperty("interactive")
    private boolean interactive;

    @JsonProperty("instruction")
    private Map<String, String> instruction;

    @JsonProperty("home_url")
    private String homeUrl;

    @JsonProperty("login_url")
    private String loginUrl;

    @JsonProperty("logo_url")
    private String logoUrl;

    @JsonProperty("form_fields")
    private List<Map<String, Object>> formFields;

    @JsonProperty("supported_account_extra_fields")
    private List<Map<String, Object>> supportedAccountExtraFields;

    @JsonProperty("supported_transaction_extra_fields")
    private List<Map<String, Object>> supportedTransactionExtraFields;
} 