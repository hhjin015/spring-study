package com.github.hhjin015;

import com.github.hhjin015.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// application layer
@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public Todo create(String name) {
        Todo todo = new Todo(IdGenerator.get(), name);
        repository.save(todo);
        return todo;
    }

    public Todo findById(int id) {
        return repository.findById(id);
    }

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Todo deleteById(int id) {
        return repository.deleteById(id);
    }
}
