package com.github.hhjin015.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTestSupports {
    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "mysecretpassword";

    public static void initWith(String ddl) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        PreparedStatement pstmt = conn.prepareStatement(ddl);

        pstmt.execute();
    }
}
