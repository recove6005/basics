package com.koreait.servletproject1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/forward") // 달아주면 xml 수정이 필요없음
public class ForwardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello ForwardServlet is comming!");
        // 1)
        // sendRedirect(경로) : 실행 시 해당 경로로 바로 이동. GET 요청.
        // resp.sendRedirect("calc?num1=2&num2=3");

        // 2)
        // refresh(경로;url) : n초 후 재요청. GET 요청.
        // resp.addHeader("Refresh", "3;url=calc?v1=2&v2=3");
        // 또는
        // PrintWriter writer = resp.getWriter();
        // writer.print("<script type=\"text/javascript\">\n" + "   location.href = 'home.html';\n" + "</script>");

        // 3)
        // GET 요청.
        // 내부적으로 calc에 전달.
        RequestDispatcher dispatcher = req.getRequestDispatcher("calc?v1=7&v2=4");
        dispatcher.forward(req, resp);



    }
}
