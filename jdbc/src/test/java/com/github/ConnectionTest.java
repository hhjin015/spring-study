package com.github;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class ConnectionTest {

    private final static String URL = "jdbc:h2:mem:test";
    private final static String USERNAME = "sa";
    private final static String PASSWORD = "";

    @Test
    void name() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        final PreparedStatement statement = connection.prepareStatement("DROP TABLE IF EXISTS member CASCADE; " +
                "CREATE TABLE member (id bigint , name varchar(255), primary key (id));");
        statement.execute();

        Connection connection2 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement ps2 = connection2.prepareStatement("SELECT count(*) FROM member;");
        ResultSet rs = ps2.executeQuery();
        rs.next();
        int anInt = rs.getInt(1);
        System.out.println("anInt = " + anInt);
    }
}
