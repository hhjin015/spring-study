package com.github.hhjin015;

import com.github.hhjin015.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo create(String name) {
        Todo todo = new Todo(name);
        repository.save(todo);
        return todo;
    }

    public Todo findBy(String name) {
        return repository.findByName(name);
    }
}
