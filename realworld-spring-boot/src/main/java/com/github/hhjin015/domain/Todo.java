package com.github.hhjin015.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Todo {

    public static Todo newTodo(long id, String name) {
        return new Todo(id, name, false, LocalDateTime.now(), null, "PLANNED");
    }

    // NOTE 오로지 db 에서 인스턴스화 시킬때만 사용할 것!
    public static Todo loadFromDB(long id, String name, boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String status) {
        return new Todo(id, name, isDeleted, createdAt, updatedAt, status);
    }

    long id;
    String name;
    boolean isDeleted;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String status;

    private Todo(long id, String name, boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String status) {
        this.id = id;
        this.name = name;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public void rename(String name) {
        this.name = name;
        this.updatedAt = LocalDateTime.now();
    }

    public void transitTo(String status) {
        this.status = status;
    }
}
