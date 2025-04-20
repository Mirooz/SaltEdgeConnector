package com.saltedge.connector.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "saltedge")
public class SaltEdgeProperties {
    private String apiUrl;
    private String appId;
    private String secret;
}
