package com.github.hhjin015;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration TODO step 1. using @Configuration
public class MyConfig {

    // @Bean TODO step 1. using @Configuration
    public HelloController xx() {
        return new HelloController(null);
    }
}
