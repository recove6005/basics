package com.koreait.servletproject1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/accept")
public class AcceptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        // 1)
        // Object 객체로 받아온 값들을 다운 캐스팅
        // String name = (String)req.getAttribute("name");
        // int birth = (Integer)req.getAttribute("birth");

        // 2)
        String name = req.getParameter("name");
        int age = (Integer) req.getAttribute("age");

        PrintWriter writer = resp.getWriter();

        // bind.html
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>bind</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Received Data!</h1>\n" +
                "    name : <span>"+ name +"</span> <br/>\n" +
                "    age : <span>" + age + "</span> <br/>\n" +
                "</body>\n" +
                "</html>");
    }
}
