package com.github.hhjin015.service;

import com.github.hhjin015.repository.JdbcTodoRepository;
import com.github.hhjin015.util.IdGenerator;
import com.github.hhjin015.domain.Todo;
import com.github.hhjin015.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// application layer
@Service
@RequiredArgsConstructor
public class TodoService {
    /**
     * TODO
     * <p>
     * service class 가 가져야하는 책임 != business logic
     * -> orchestration
     * -> repository 에서 x 를 꺼내오고 x 한테 y 라는 기능 수행해줘. 그리고 다시 repository 에 x 를 저장해줘
     */

    private final TodoRepository repository;
    private final JdbcTodoRepository jdbcTodoRepository;

    // command
    public Todo create(String name) {
        Todo todo = Todo.newTodo(IdGenerator.get(), name);
        repository.save(todo);
        return todo;
    }

    // command
    public int deleteById(long id) {
        return repository.deleteById(id);
    }

    // command
    public Todo update(long id, String name) {
        Todo todo = repository.findById(id);
        // 1. 레이어와 도메인 관점에서 설명
        // 2. 캡슐화
        // 3. 자율성
        todo.rename(name);

        return todo;
    }

    // command
    public Todo updateStatus(long id, String status) {
        Todo todo = findById(id);
        todo.transitTo(status);

        return todo;
    }

    // query
    public Todo findById(long id) {
        return jdbcTodoRepository.findById(id);
    }

    // query
    public List<Todo> findAll() {
        return repository.findAll();
    }
}
