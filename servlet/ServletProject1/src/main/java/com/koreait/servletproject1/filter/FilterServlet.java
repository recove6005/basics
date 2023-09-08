package com.koreait.servletproject1.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


// 주의 :: javax.servlet.Filter
// 어떤 서블릿 url이 왔을 때 filter를 동작시킬지?
// 모든 서블릿에 대해 -> /*
//
@WebFilter("/*")
public class FilterServlet implements Filter {
    // init, destroy 선택
    // doFilter 필수


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        context = filterConfig.getServletContext();
    }

    ServletContext context;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ServletFilter is called.");
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html; charset=utf-8");

        // HttpServletRequest는 ServletRequests를 extends 함.
        String context = ((HttpServletRequest)servletRequest).getContextPath(); //
        String path = ((HttpServletRequest)servletRequest).getRequestURI(); // URI. 요청경로
        String realPath = servletRequest.getRealPath(path); // 물리적 경로
        String msg = "context : " + context + "\n" + "path : " + path + "\n" + "realPath : " + realPath;
        System.out.println(msg);


        long startTime = System.currentTimeMillis(); // 요청 전달 직전의 시작 시간

        // doFilter 실행 시 원래 서블릿에게 요청과 응답 전달
        filterChain.doFilter(servletRequest, servletResponse); // req, resp 모두 넘겨줌
        // 위 구문 실행되고 나면 원래 서블릿이 응답을 마친 상태
        // 만약 filter에서 해야할 응답이 있으면 doFilter 아래쪽에 작성

        long endTime = System.currentTimeMillis(); // 요청에 대해 서블릿 응답이 끝난 후 시간

        System.out.println("Total Time : " + (endTime - startTime) + "ms"); // 전체 걸린 시간
    }
}
