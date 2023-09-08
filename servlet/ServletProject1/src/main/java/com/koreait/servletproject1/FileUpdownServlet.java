package com.koreait.servletproject1;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(urlPatterns = {"/upload", "/download"})
public class FileUpdownServlet extends HttpServlet {
    ServletContext context;
    @Override
    public void init() throws ServletException {
        getServletContext();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String fileName = req.getParameter("fileName");

        PrintWriter writer = resp.getWriter();

        // 실제로 파일을 다운로드
        // resp.getOutputStream().write();

        try(InputStream in = context.getResourceAsStream("/files/" + fileName + ".txt");) {
            String contents = new String(in.readAllBytes());
            writer.println();

        } catch(Exception e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
