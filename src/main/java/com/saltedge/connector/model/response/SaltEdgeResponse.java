package com.saltedge.connector.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SaltEdgeResponse<T> {
    @JsonProperty("data")
    private List<T> data;

    @JsonProperty("meta")
    private Meta meta;

    @Data
    public static class Meta {
        @JsonProperty("next_id")
        private String nextId;

        @JsonProperty("next_page")
        private String nextPage;
    }
} 