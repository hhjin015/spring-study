package com.github.hhjin015;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/todos/{name}")
    public ResponseEntity<Todo> find(@PathVariable String name) {
        Todo todo = service.findBy(name);
        return ResponseEntity.ok(todo);
    }
}
