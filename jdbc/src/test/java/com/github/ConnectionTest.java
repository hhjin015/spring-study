package com.github;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class ConnectionTest {

    private final static String URL = "jdbc:h2:mem:test";
    private final static String USERNAME = "sa";
    private final static String PASSWORD = "";

    @BeforeEach
    void setUp() throws Exception {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        final PreparedStatement statement = connection.prepareStatement("DROP TABLE IF EXISTS member CASCADE; " +
                "CREATE TABLE member (id bigint , name varchar(255), primary key (id));");
        statement.execute();
    }

    @Test
    void a2() throws SQLException {
        Connection connection2 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement ps2 = connection2.prepareStatement("SELECT count(*) FROM member;");
        ResultSet rs = ps2.executeQuery();
        rs.next();
        int anInt = rs.getInt(1);
        System.out.println("anInt = " + anInt);
    }

    @Test
    @DisplayName("insert 가능")
    void a3() throws SQLException {
        Connection c1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement ps = c1.prepareStatement("INSERT INTO member (id, name) VALUES (1, 'jang')");
        ps.execute();
    }

    @Test
    @DisplayName("select 가능")
    void a4() throws SQLException {
        Connection c1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement ps = c1.prepareStatement("INSERT INTO member (id, name) VALUES (1, 'jang')");
        ps.execute();

        Connection c2 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        ResultSet rs = c2.prepareStatement("SELECT * FROM member").executeQuery();
        rs.next();

        int anInt = rs.getInt(1);
        String string = rs.getString(2);

        System.out.println("string = " + string);
        System.out.println("anInt = " + anInt);
    }
}
