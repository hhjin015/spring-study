package com.github.hhjin015.controller;

import com.github.hhjin015.request.CreateTodoRequest;
import com.github.hhjin015.service.TodoService;
import com.github.hhjin015.domain.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // json 을 반환해
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping(value = "/todos")
    public ResponseEntity<Todo> create(@RequestBody CreateTodoRequest body) {
        Todo todo = service.create(body.getName());
        return ResponseEntity.ok(todo);
    }

    @GetMapping(value = "/todos")
    public ResponseEntity<List<Todo>> findAll() {
        List<Todo> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/todos/{id}")
    public ResponseEntity<Todo> findById(@PathVariable long id) {
        Todo todo = service.findById(id);
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping(value = "/todos/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable long id) {
        int isSuccess = service.deleteById(id);
        return ResponseEntity.ok(isSuccess);
    }

    @PutMapping(value = "/todos/{id}")
    public ResponseEntity<Todo> update(@PathVariable long id, @RequestBody CreateTodoRequest body) {
        // TODO SRP (single responsible principal) 를 적용해보자!

        Todo todo = service.update(id, body.getName());

        return ResponseEntity.ok(todo);
    }

    @PutMapping(value = "/todos/status/{id}")
    public ResponseEntity<Todo> updateStatus(@PathVariable long id, @RequestBody Map<String, String> map) {
        // TODO map 보다 명시적인 클래스로 분리하는 것도 좋아보여요
        // 근데 꼭 request Body 1: 1 dto class 이건 아니고, 이런식으로 map 으로 받는것도 not bad
        Todo todo = service.updateStatus(id, map.get("status"));
        return ResponseEntity.ok(todo);
    }
}
