package com.example.security.service;

import com.example.security.dto.UserDTO;
import com.example.security.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void post_register(UserDTO userDTO) {
        // 기존 평문 패스워드 인코딩
        String encodedPw = passwordEncoder.encode(userDTO.getPassword());
        System.out.println(encodedPw);
        // 전달받은 유저 객체에 설정
        userDTO.setPassword(encodedPw);
        // DB, 회원가입 시도
        loginMapper.post_user(userDTO);
    }
}
