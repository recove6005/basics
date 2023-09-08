package com.koreait.servletproject1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalcServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Calc constext is created.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get req is accepted. - Calc");
        doGP(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post req is accepted. - Calc");
        doGP(req, resp);
    }

    // get, post 모두 실행하려면
    // doGP(req, resp); 를 doGet, doPost 모두에서 실행
    protected void doGP(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();

        String v1 = req.getParameter("v1");
        String v2 = req.getParameter("v2");
        int result = Integer.parseInt(v1) + Integer.parseInt(v2);

        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>bin</title>\n" +
                "</head>\n" +
                "<body>\n" +
                v1 + " + " + v2 + " = " + result +
                "</body>\n" +
                "</html>");

        System.out.println("write is completed.");
    }


    @Override
    public void destroy() {

    }
}
