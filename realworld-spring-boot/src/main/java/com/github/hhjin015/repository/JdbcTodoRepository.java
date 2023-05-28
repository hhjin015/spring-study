package com.github.hhjin015.repository;

import com.github.hhjin015.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcTodoRepository implements TodoRepository {

    private final DataSource dataSource;

    @Override
    public void save(Todo todo) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement("INSERT INTO todos (id, name, is_deleted, created_at, updated_at, status) VALUES (?,?,?,?,?,?)");
            ps.setLong(1, todo.getId());
            ps.setString(2, todo.getName());
            ps.setBoolean(3, todo.isDeleted());
            ps.setObject(4, todo.getCreatedAt());
            ps.setObject(5, todo.getUpdatedAt());
            ps.setString(6, todo.getStatus());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Todo findById(long id) {
        Connection connection = null;
        PreparedStatement ps = null;
        Todo todo;
        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement("SELECT * FROM todos WHERE id = (?)");
            ps.setLong(1, id);

            ResultSet resultSet = ps.executeQuery();
            resultSet.next();

            return Todo.loadFromDB(
                    resultSet.getLong(1),
                    resultSet.getString(2),
                    resultSet.getBoolean(3),
                    resultSet.getObject(4, LocalDateTime.class),
                    resultSet.getObject(5, LocalDateTime.class),
                    resultSet.getString(6));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
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
