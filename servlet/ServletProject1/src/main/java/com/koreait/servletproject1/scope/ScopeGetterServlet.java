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
import java.util.Arrays;

@WebServlet("/getAttr")
public class ScopeGetterServlet extends HttpServlet {
    // doGet 요청을 받으면 바인딩
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String ctxMsg = (String)getServletContext().getAttribute("ctxMsg");
        String sessionMsg =  (String)req.getSession().getAttribute("sessionMsg");
        String reqMsg = (String)req.getAttribute("reqMsg");

        Arrays.stream(req.getCookies()).forEach(c -> { String cookieMsg = c.getValue() + " / " + c.getName();
        writer.println("<div>cookie value => <span>"+ cookieMsg +"</span></div>");});

        writer.print(
                "<div>context value => <span>"+ ctxMsg +"</span></div>\n" +
                "<div>session value => <span>"+ sessionMsg +"</span></div>\n" +
                "<div>request value => <span>"+ reqMsg +"</span></div>\n"
        );
    }
}
