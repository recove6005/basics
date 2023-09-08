package com.koreait.servletproject1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

// session을 이용한 로그인 기본
@WebServlet("/logins")
public class LoginSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 링크로 바로 옴
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 로그인해서 옴
        doHandle(req, resp);
    }

    protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        // 요청에 사용된 정보들을 받아온다.
        String userID = req.getParameter("user-id");
        String userPw = req.getParameter("user-pw");
        String userNick = req.getParameter("user-nick");

        // 세션을 받아온다. (첫 실행이면 새 것, 한번이라도 요청되었으면 기존 세션)
        HttpSession session = req.getSession();
        if(session.isNew()) {
            // 첫 접속 => 로그인 or url
            // 첫 실행인 새 세션 (로그인 됨). POST 요청.
            // 세션 정보에 로그인 정보를 BINDING.
            if(userID != null && userPw != null && userNick != null) {
                // 로그인으로 온 경우
                session.setAttribute("user-id", userID);
                session.setAttribute("user-pw", userPw);
                session.setAttribute("user-nick", userNick);
                resp.sendRedirect("/logins"); // 나에게 GET으로 다시 요청 (sendRedirect는 GET요청)
            }
            else {
                // url 로 바로 온 경우
                writer.println("<h3>You do not login. </h3>\n" + "<a href=\"/logins.html\">Go to login</a>");
                // 로그인하지 않은 상태로 첫 세션이 만들어졌기 때문에 세션 파기 후 로그인
                session.invalidate();
            }
        }
        else {
            // 첫 접속이 아닌 경우 (한번이라도 로그인이 된 상태)
            // 세션에 바인딩된 정보를 가져옴.
            userID = (String)session.getAttribute("user-id");
            userPw = (String)session.getAttribute("user-pw");
            userNick = (String)session.getAttribute("user-nick");

            writer.println(
                    "<div><b>ID: </b><span>" + userID + "</span></div>\n" +
                    "<div><b>PW: </b><span>" + userPw + "</span></div>\n" +
                    "<div><b>Nick: </b><span>" + userNick + "</span></div>"
            );
        }
    }
}