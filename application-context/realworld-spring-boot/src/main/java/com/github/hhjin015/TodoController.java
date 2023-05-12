package com.github.hhjin015;

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
    public ResponseEntity<Todo> deleteById(@PathVariable long id) {
        Todo todo = service.deleteById(id);
        return ResponseEntity.ok(todo);
    }

    @PutMapping(value = "/todos/{id}")
    public ResponseEntity<Todo> update(@PathVariable long id, @RequestBody CreateTodoRequest body) {
        Todo todo = service.update(id, body.getName());

        return ResponseEntity.ok(todo);
    }

    @PutMapping(value = "/todos/status/{id}")
    public ResponseEntity<Todo> updateStatus(@PathVariable long id, @RequestBody Map<String, String> map) {
        Todo todo = service.updateStatus(id, map.get("status"));

        return ResponseEntity.ok(todo);
    }
}
