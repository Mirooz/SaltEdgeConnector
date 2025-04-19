package com.saltedge.connector.model.response;

import lombok.Data;

@Data
public class SaltEdgeSingleResponse<T> {
    private T data;
}
