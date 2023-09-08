package com.koreait.servletproject1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/file")
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain");

        PrintWriter writer = resp.getWriter();

        // files 디렉터리의 파일 읽어오기
        try(InputStream in = req.getServletContext().getResourceAsStream("/files/text.txt"); ) {
            writer.println(new String(in.readAllBytes()));
        } catch (Exception e) {
            writer.println("nha!");
        }

        writer.println();

    }
}
