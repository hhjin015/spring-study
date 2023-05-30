package com.github.hhjin015.repository;

import com.github.hhjin015.domain.Todo;

import java.util.*;

//@Repository
public class InMemoryTodoRepository implements TodoRepository {

    private final Map<String, Todo> storage = new HashMap<>();

    @Override
    public void save(Todo todo) {
        if (storage.containsKey(todo.getName())) {
            throw new RuntimeException();
        } else {
            storage.put(todo.getName(), todo);
        }
    }

    @Override
    public Todo findById(long id) {
        for (String str : storage.keySet()) {
            Todo todo = storage.get(str);
            if (todo.getId() == id && !todo.isDeleted()) return todo;
        }
        return null;
    }

    @Override
    public List<Todo> findAll() {
        List<Todo> list = new ArrayList<>();
        for (String str : storage.keySet()) {
            if (!storage.get(str).isDeleted()) list.add(storage.get(str));
        }
        return list;
    }

    @Override
    public int deleteById(long id) {
        for (String str : storage.keySet()) {
            Todo todo = storage.get(str);
            if (todo.getId() == id) {
                todo.setDeleted(true);
                return 1;
            }
        }
        return 0;
    }
}
