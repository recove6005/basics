package com.example.security.service;

import com.example.security.dto.UserDTO;
import com.example.security.mapper.LoginMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info(" ======= loadUserByUsername: ["+ username + "]");
        // html form 내의 username 을 name 속성으로 가진 input value가 자동으로 전달됨.
        // 로그인을 시도한 유저의 이름(id)가 DB에 있는지 확인 후
        // UserDTO를 가져옴
        UserDTO userDTO = loginMapper.get_user_by_id(username);
        if(userDTO == null) {
            // DB에 유저를 찾을 수 없음
            throw new UsernameNotFoundException("ERROR: USER NOT FOUND!");
            // return null;
        }

        // 유저 객체가 DB에 있다면 User 객체 생성 후 반환
        return User
                .withUsername(userDTO.getUserID())
                .password(userDTO.getPassword())
                .authorities("READ")
                .build();

//        UserDetails user = User.withUsername("james").password("123").authorities("READ").build();

//        if(user.getUsername().equals(username)){
//            return user;
//        }else{
//            throw new UsernameNotFoundException("ERROR: USER NOT FOUND!");
//        }
    }
}


// localhost:0808/logout
// localhost:8080/login/main?logout
// 로그인 세션을 자동으로 삭제