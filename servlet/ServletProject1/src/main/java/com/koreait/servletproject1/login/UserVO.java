package com.koreait.servletproject1.login;

// VO : Value Object. DB의 table 정의 객체.
// DB 테이블 1행의 정보를 모두 담은 객체(Entity)
public class UserVO {
    private String id;
    private String pw;
    private String nickname;

    public UserVO(String id, String pw, String nickname) {
        this.id = id;
        this.pw = pw;
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getNickname() {
        return nickname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
