package com.example.security.user;

import com.example.security.vo.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class DummyUser extends User {
    private UserVO userVO;

    public DummyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    //    public DummyUser(UserVO userVO) {
//        this.userVO = userVO;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // read 권한을 collection으로 반환
//        return List.of(() -> userVO.getAuthorities());
//    }


//    @Override
//    public String getPassword() {
//        return "456";
//    }
//
//    @Override
//    public String getUsername() {
//        return "james";
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
