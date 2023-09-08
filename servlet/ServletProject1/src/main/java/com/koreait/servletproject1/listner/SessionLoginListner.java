package com.koreait.servletproject1.listner;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

// HttpSessionBindingListner : 세션 생성, 소멸 시 발생되는 이벤트
public class SessionLoginListner implements HttpSessionBindingListener {
    static int totalUserCnt = 0; // 로그인한 전체 유저 수
    // 모든 세션에서 공유할 수 있도록 static => SessionLoginListener.totalUserCnt
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // 세션 생성 시 발생되는 이벤트
        System.out.println("valueBound -- 세션에 바인딩 됨 -- 사용자 로그인");
        totalUserCnt++;
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // 세션 소멸 시 발생되는 이벤트
        System.out.println("valueBound -- 세션에 언바인딩되었음 -- 사용자 로그아웃");
        totalUserCnt--;
    }
}
