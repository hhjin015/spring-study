package com.github.hhjin015;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Todo> findById(@PathVariable int id) {
        Todo todo = service.findById(id);
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping(value = "/todos/{id}")
    public ResponseEntity<Todo> deleteById(@PathVariable int id) {
        Todo todo = service.deleteById(id);
        return ResponseEntity.ok(todo);
    }
}
