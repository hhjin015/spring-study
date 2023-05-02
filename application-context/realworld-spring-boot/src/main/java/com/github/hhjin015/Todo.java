package com.github.hhjin015;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class Todo {
    String name;
    LocalDateTime createdAt;

    public Todo(String name) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }
}
