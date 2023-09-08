package com.koreait.servletproject1.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

// 사용자의 요청을 받을 서블릿. `Controller`라고 함.
@WebServlet("/login")
public class ControllerServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;chrset=utf-8");
            PrintWriter writer = resp.getWriter();

            // 1) login.html 에서 사용자의 입력 정보로 post 요청 -> controller
            // Controller에서 받은 id, pw, nickname 정보로 DB 조회 후 데이터 반환
            String id = req.getParameter("user-id");
            String pw = req.getParameter("user-pw");
            UserVO vo = userDAO.get_user(id, pw);
        if(vo == null) {
            // 3-2 로그인 실패.
            writer.println("Login failed.");
            writer.println("<a href='/logins.html'>try again.</a>");
        } else {
            // 3-1 로그인 성공.
            writer.println(
                    "<div><b>아이디:</b><span>" + vo.getId() + "</span></div>\n" +
                    "<div><b>패스워드:</b><span>" + vo.getPw() + "</span></div>\n" +
                    "<div><b>닉네임:</b><span>" + vo.getNickname() + "</span></div>");
        }
    }

}
