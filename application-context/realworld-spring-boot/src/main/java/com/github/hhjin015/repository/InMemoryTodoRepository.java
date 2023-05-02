package com.github.hhjin015.repository;

import com.github.hhjin015.Todo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryTodoRepository implements TodoRepository {

    private final Map<String, Todo> storage = new HashMap<>();

    @Override
    public void save(Todo todo) {
        storage.put(todo.getName(), todo);
    }

    @Override
    public Todo findByName(String name) {
        return storage.get(name);
    }
}
