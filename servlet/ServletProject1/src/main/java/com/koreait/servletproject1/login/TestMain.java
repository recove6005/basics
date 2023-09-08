package com.koreait.servletproject1.login;

import java.sql.Connection;

public class TestMain {
    public static void main(String[] args) {
        Connection conn = new DBConnection().get_connection();

    }
}
