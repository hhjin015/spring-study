package com.github.hhjin015;

import com.github.hhjin015.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Todo findById(long id) {
        return repository.findById(id);
    }

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Todo deleteById(long id) {
        return repository.deleteById(id);
    }

    public Todo update(long id, String name) {
        Todo todo = repository.findById(id);
        todo.setName(name);
        todo.setUpdatedAt(LocalDateTime.now());

        return todo;
    }

    public Todo updateStatus(long id, String status) {
        Todo todo = findById(id);
        todo.setStatus(status);

        return todo;
    }
}
