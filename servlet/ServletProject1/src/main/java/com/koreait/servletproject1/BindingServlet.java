package com.koreait.servletproject1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bind")
public class BindingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        // 1)
        // 현재 서블릿에서 어떤 데이터를 생성한 후 bind(묶어줌).
        // AcceptServelet으로 req로 보낼 값들
        // AcceptServlet에서 req.getAttribute()로 받음, Object로 받으므로 다운 캐스팅
        // req.setAttribute("name", "leehan");
        // req.setAttribute("age", 26);

        // 요청을 redirect (/accept 로 - AcceptServlet)
        // resp.sendRedirect("/accept");
        // RequestDispatcher dispatcher = req.getRequestDispatcher("accept");
        // dispatcher.forward(req, resp);

        // 2)
        String name = req.getParameter("name");
        String birth = req.getParameter("birth");
        req.setAttribute("age", 2023 - Integer.parseInt(birth)); // int(parse), Integer(valueOf)
        RequestDispatcher dispatcher = req.getRequestDispatcher("accept?name="+name);
        dispatcher.forward(req, resp);

    }
}
