package com.koreait.servletproject1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("id : " + session.getId());
        System.out.println("최초 생성 기간 : " + new Date(session.getCreationTime()));
        System.out.println("최초 접근 기간 : " + new Date(session.getLastAccessedTime()));
        System.out.println("유효 시간 : " + session.getMaxInactiveInterval());
        // JSESSIONID 쿠키가 생성됨
    }
}
