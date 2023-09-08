package com.koreait.servletproject1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (
        urlPatterns = {"/conf", "/conf1", "/conf2"}, // url 겹치면 오류
        initParams = {
                @WebInitParam(name="conf", value = "10"),
                @WebInitParam(name="conf1", value = "20"),
                @WebInitParam(name="conf2", value = "30")
        }
)
public class ConfServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    // servlet config가 필요없다면 다음의 init을 쓸 것.
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(getInitParameter("conf"));
        System.out.println(getInitParameter("conf1"));
        System.out.println(getInitParameter("conf2"));
    }
}