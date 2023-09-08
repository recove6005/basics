package com.koreait.servletproject1.users;

import com.koreait.servletproject1.listner.SessionLoginListner;
import com.koreait.servletproject1.login.UserDAO;
import com.koreait.servletproject1.login.UserVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

        public class UsersBoardServlet extends HttpServlet {
            private UserDAO userDAO;
            SessionLoginListner loginListner;

            @Override
            public void init() throws ServletException {
                userDAO = new UserDAO();
            }

            @Override
            protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String userId = req.getParameter("user-id");
        String userPw = req.getParameter("user-pw");
        PrintWriter writer = resp.getWriter();
        UserVO vo = userDAO.get_user(userId, userPw);

        if(vo == null) {
            writer.println("<h1>Please login first.</h1>\n" + "<a href=\"login.html\">Go to login</a>");
            // resp.sendRedirect("/users/erros.html");
        } else {
            HttpSession session = req.getSession();
            if(session.isNew()) {

                // 새로운 세션이면 세션 생성 후 totalCnt ++
                session.setAttribute("user", loginListner);
            }
                writer.print("  <h1>You are on login.</h1>\n" +
                        "  <div>\n" +
                        "    ID: <b>"+ vo.getId() +"</b>\n" +
                        "    Nickname: <b>" + vo.getNickname() + "</b>\n" +
                        "  </div>\n" +
                        "  <a href=\"\">Logout</a>");
                // resp.sendRedirect("/users/board.html");
        }
    }
}
