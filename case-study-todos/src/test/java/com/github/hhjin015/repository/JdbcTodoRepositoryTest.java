package com.github.hhjin015.repository;

import com.github.hhjin015.domain.Todo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class JdbcTodoRepositoryTest {

    public static final String DDL = "DROP TABLE IF EXISTS todos; " +
            "CREATE TABLE todos " +
            "(id bigint PRIMARY KEY, " +
            "name VARCHAR(50), " +
            "is_deleted boolean, " +
            "created_at timestamp, " +
            "updated_at timestamp, " +
            "status VARCHAR(10))";

    @Autowired
    JdbcTodoRepository sut;

    @BeforeEach
    void setUp() throws SQLException {
        DBTestSupports.initWith(DDL);
    }

    @Test
    void name() {
        String name = "jang";
        Todo todo = Todo.newTodo(1, name);
        sut.save(todo);

        Todo actual = sut.findById(1);
        Assertions.assertThat(actual.getName()).isEqualTo(name);

        int actual2 = sut.deleteById(1);
        Assertions.assertThat(actual2).isEqualTo(1);

        Todo actual3 = sut.findById(1);
        Assertions.assertThat(actual3).isNull();
    }

    @Test
    void findAll() {
        sut.save(Todo.newTodo(1, "jang"));
        sut.save(Todo.newTodo(2, "heo"));
        sut.save(Todo.newTodo(3, "kim"));
        sut.save(Todo.newTodo(4, "james"));

        sut.deleteById(2);

        List<Todo> actual = sut.findAll();

        Assertions.assertThat(actual.size()).isEqualTo(3);
    }
}