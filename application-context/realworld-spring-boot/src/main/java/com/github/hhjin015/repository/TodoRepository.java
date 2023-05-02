package com.github.hhjin015.repository;

import com.github.hhjin015.Todo;
import org.springframework.stereotype.Repository;

public interface TodoRepository {
    void save(Todo todo);

    Todo findByName(String name);
}
