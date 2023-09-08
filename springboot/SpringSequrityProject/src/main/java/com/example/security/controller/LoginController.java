package com.example.security.controller;

import com.example.security.dto.UserDTO;
import com.example.security.service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/logout")
    public String get_logout() {
        return "redirect:/board/main";
    }

    @GetMapping("/login/main")
    // logcalhost:8080/login/main?error
    public void get_login(Model model, String error
            //, @AuthenticationPrincipal UserDetails userDetails
            ) {
        log.info("Move to Login Page");
        if(error != null && error.isEmpty()){
            model.addAttribute("errorMessage", "! 로그인 실패했어요 !");
        }

        // 어떤 유저가 로그인 되어있는지 아닌지를 판단
//        if(userDetails != null) {
//            System.out.println("current user in login : " + userDetails.getUsername());
//        }
        //        if(error.isEmpty()) {
//            // isEmpty() : 빈문자열
//            // isBlank() : 빈문자열, null
//            // error 가 없음
//            System.out.println("Your login is failed.");
//        }
    }

    @GetMapping("/login/register")
    public void get_register() {

    }

    @PostMapping("/login/register")
    public String post_register(UserDTO userDTO){
        loginService.post_register(userDTO);
        return "redirect:/board/main";
    }


}
