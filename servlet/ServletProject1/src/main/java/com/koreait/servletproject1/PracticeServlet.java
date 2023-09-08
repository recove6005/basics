package com.koreait.servletproject1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet("/practice")
public class PracticeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = getServletContext().getContextPath();
        System.out.println(path);

        try {
            FileOutputStream oos = new FileOutputStream(path + "/text.txt");
        } catch(Exception e) {
            System.out.println("text21");
            System.out.println(e.getMessage());
        }
        try {
            FileOutputStream oos = new FileOutputStream("text2.txt");
        } catch(Exception e) {
            System.out.println("text2");
            System.out.println(e.getMessage());
        }
    }
}
