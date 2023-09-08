package com.koreait.servletproject1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;

public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get req is accepted from seconds. - DO_GET");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post req is accepted from seconds. - DO_POST");

        //가져온 데이터에 대해 인코딩 설정
        req.setCharacterEncoding("utf-8");
        // 사용자 화면에 보여주는 인코딩 설정 (한글)
        resp.setCharacterEncoding("UTF-8");
        // 사용자에게 보내줄 데이터 형식 지정
        resp.setContentType("text/plain");
        // 응답 데이터를 웹 브라우저에 write해줄 수 있는 Writer 객체를 받아옴
        PrintWriter writer = resp.getWriter();

        // 받은 데이터를 모두 순회
        Enumeration<String> enumeration = req.getParameterNames(); // checkbox의 여러 개의 값을 한 번에 받아온 값들
        Iterator<String> iterator = enumeration.asIterator();
        while(iterator.hasNext()) {
            String name = iterator.next(); // 가져온 현재의 name값
//            String value = req.getParameter(name); // 가져온 name값으로 value값을 가져옴
//            System.out.println("name : " + name + " / " + " / value : " + value);

            // 가져온 name 값으로 value값을 가져온다
            Arrays.stream(req.getParameterValues("subject")).forEach(writer::println);
        }
        // 로그 작성
        System.out.println("Wr is completed.");
//        writer.println();
    }
}
