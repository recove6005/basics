package com.koreait.servletproject1.scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

//230725 - 서블릿 스코프
@WebServlet("/setAttr")
public class ScopeServlet extends HttpServlet {
    // doGet 요청을 받으면 바인딩
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String ctxMsg = "Context Messege";
        String cookieMsg = "Cookie Messege";
        String sessionMsg = "Session Messege";
        String reqMsg = "Request Messege";

        // context에 바인딩 - 스코프 : 어플리케이션 전체
        getServletContext().setAttribute("ctxMsg",ctxMsg);

        // session에 바인딩 - 스코프 : 브라우저
        req.getSession().setAttribute("sessionMsg",sessionMsg);

        // request에 바인딩 - 무조건 null, 스코프 : 요청 응답
        req.setAttribute("reqMsg", reqMsg);

        // cookie에 바인딩
        Cookie cookie = new Cookie("cookieMsg", URLEncoder.encode(cookieMsg, "utf-8"));
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
