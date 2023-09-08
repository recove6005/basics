package com.koreait.servletproject1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/snd")
public class snd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("This page is forwarding page.");

        // 1) sendRedirect() 를 이용한 포워딩
        // resp.sendRedirect("ftarget");

        // 2) addHeader() 를 이용한 포워딩
        // resp.addHeader("Refresh", "3;url=ftarget");

        // 3) RequestDispatcher 클래스를 이용한 포워딩
        RequestDispatcher dis = req.getRequestDispatcher("ftarget");
        dis.forward(req, resp);
    }
}
