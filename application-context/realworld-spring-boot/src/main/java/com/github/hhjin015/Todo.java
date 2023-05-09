package com.github.hhjin015;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Todo {

    long id;
    String name;
    boolean isDeleted;
    LocalDateTime createdAt;

    public Todo(long id, String name) {
        this.id = id;
        this.name = name;
        this.isDeleted = false;
        this.createdAt = LocalDateTime.now();
    }
}
