package com.koreait.servletproject1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/context") // bind.html
public class ContextServlet extends HttpServlet {
    ServletContext context;
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("context init completed.");
        context = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // context.setAttribute("members", Arrays.asList("A1", "A2", "A3"));
        // System.out.println(context.getAttribute("members")); // null, 아직 만들어지지 않은 값. /context 실행 후 다시 /context로 가면 값이 호출됨

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("param : " + context.getInitParameter("members_height"));

        context.setAttribute("members", Arrays.asList("A1", "A2", "A3"));
        context.setAttribute("city", "seoul");

        writer.print(context.getAttribute("city"));
        List m = (ArrayList)context.getAttribute("members");
        System.out.println(m.get(0) + " / " + m.get(1) + " / " + m.get(2));
        writer.print(context.getAttribute("city"));

    }
}