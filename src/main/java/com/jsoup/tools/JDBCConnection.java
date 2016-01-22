package com.jsoup.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by vladimir on 20.01.16.
 */
public class JDBCConnection {

    private static final String url = "jdbc:mysql://localhost/vacancies";
    private static final String name = "root";
    private static final String pass = "root";
    
    private JDBCConnection(){}

    public static Connection getConnection() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, name, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (conn != null) {
            System.out.println("Connection is OK!");
        }

        return conn;
    }
}
