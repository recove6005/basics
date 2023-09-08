package com.example.security.vo;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@ToString
public class UserVO extends User {
    private String userID;
    private String password;
//    private List<String> authorities; // 유저가 가지는 권한(들)

    public UserVO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userID = username;
        this.password = password;

//        this.authorities = authorities.stream().collect(List<String> :: new);
    }
}
