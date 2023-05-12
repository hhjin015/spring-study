package com.github.hhjin015.repository;

import com.github.hhjin015.Todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class JdbcTodoRepository implements TodoRepository{
    @Override
    public void save(Todo todo) {

    }

    @Override
    public Todo findById(long id) {
        return null;
    }

    @Override
    public List<Todo> findAll() {
        return null;
    }

    @Override
    public Todo deleteById(long id) {
        return null;
    }
}
