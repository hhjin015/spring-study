package com.github.hhjin015;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Todo {

    long id;
    String name;
    boolean isDeleted;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String status;

    public Todo(long id, String name) {
        this.id = id;
        this.name = name;
        this.isDeleted = false;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;
        this.status = "PLANNED";
    }

    public void rename(String name) {
        this.name = name;
        this.updatedAt = LocalDateTime.now();
    }

    public void transitTo(String status) {
        this.status = status;
    }
}
