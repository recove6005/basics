package com.koreait.servletproject1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("The first context(servlet) is created. - INIT");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get req is accepted from first. - DO_GET");
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String nickname = req.getParameter("nickname");
        System.out.println(id + " " + pw + " " + nickname);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String name = req.getParameter("name");
        String age = req.getParameter("age");

        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>tmp</title>\n" +
                "</head>\n" +
                "<style>\n" +
                "  span {\n" +
                "    display: block;\n" +
                "    border: 1px solid black;\n" +
                "    padding: 1.2rem;\n" +
                "    background-color: bisque;\n" +
                "    \n" +
                "  }\n" +
                "</style>\n" +
                "<body>\n" +
                "  <div>\n" +
                "    name: <span>"+ name +"</span>\n" +
                "    age: <span>" + age +"</span>\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>");
        // + 로 연결
        // 또는 string format으로
    }

    @Override
    public void destroy() {
        System.out.println("The first context(servlet) is deleted. - DO_DELETE");
    }
}