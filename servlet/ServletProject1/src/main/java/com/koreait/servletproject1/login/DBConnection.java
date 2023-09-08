package com.koreait.servletproject1.login;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private String url = "jdbc:mysql://localhost:3306/servlet_db";
    private String username = "root";
    private String password = "root";

    public DBConnection() {
        // 1)
        try {
            Class.forName("com.mysql.jc.jdbc.Driver");
            System.out.println("The DB Driver upload was successful.");

        } catch (ClassNotFoundException e) {
            System.out.println("Error : The DB driver upload has failed.");
            System.exit(1);
        }
    }

    public Connection get_connection() {
        // 2)
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch(Exception e) {
            System.out.println("틀린 URL/USERNAME/PASSWORD");
            System.out.println(1);
            return null;
        }
    }
}
