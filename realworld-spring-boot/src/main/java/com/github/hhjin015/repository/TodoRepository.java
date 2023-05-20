package com.github.hhjin015.repository;

import com.github.hhjin015.Todo;

import java.util.List;

public interface TodoRepository {
    void save(Todo todo);

    Todo findById(long id);

    List<Todo> findAll();

    Todo deleteById(long id);
}
