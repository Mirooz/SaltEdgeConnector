package com.saltedge.connector.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SaltEdgeConfig.class)
public @interface EnableSaltEdgeClient {
} 