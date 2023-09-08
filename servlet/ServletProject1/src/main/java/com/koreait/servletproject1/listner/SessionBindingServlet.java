package com.koreait.servletproject1.listner;

import com.koreait.servletproject1.login.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/listen/login")
public class SessionBindingServlet extends HttpServlet {
    private SessionLoginListner loginListner;

    @Override
    public void init() throws ServletException {
        loginListner = new SessionLoginListner();
        System.out.println("Login Listner Created.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.setContentType("text/plain;charset=utf-8"); => doFilter에
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession(); // 세션 생성

        String userId = req.getParameter("user-id");
        String userPw = req.getParameter("user-pw");

        // 받아온 유저 정보 생성
        UserVO vo = new UserVO(userId, userPw, "");
        // 세션이 새로 만들어짐 -> 방금 로그인한 것
        if(session.isNew()) {
            // 로그인한 유저를 session에 바인딩
            session.setAttribute("user", loginListner);
            writer.print("<div>Current Login ID :"+ userId +"</div>\n" + "<div>Total User Cnt :"+ SessionLoginListner.totalUserCnt +"</div>");
            // 로그인 시 브라우저 당(session) 1 cnt.
        }
    }
}
