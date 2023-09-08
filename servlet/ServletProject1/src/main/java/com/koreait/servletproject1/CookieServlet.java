package com.koreait.servletproject1;

// 20230721

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 쿠키의 배열을 받아 옴
        Cookie[] cookies = req.getCookies();
        Arrays.stream(req.getCookies()).forEach(x -> {
            System.out.println("name : " + x.getName());
            try {
                System.out.println("value : " + URLDecoder.decode(x.getValue(), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain");
        Date date = new Date();
        String key = date.getMonth() + "-" + date.getDate();
        Cookie cookie = new Cookie(key, "Halo!");
        cookie.setMaxAge(24*60*60);

        resp.addCookie(cookie);

        Enumeration<String> params = req.getParameterNames();
        while(params.hasMoreElements()) {
            String name = params.nextElement();
            String value = req.getParameter(name);
            System.out.println(name + " " + value);
        }
    }
}
