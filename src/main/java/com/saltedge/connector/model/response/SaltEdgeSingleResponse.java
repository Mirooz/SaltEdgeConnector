package com.saltedge.connector.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SaltEdgeSingleResponse<T> {
    @JsonProperty("data")
    private T data;
}
