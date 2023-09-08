package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @ResponseBody
    @GetMapping("/hello")
    public String rest_main() {
        return "halo !";
    }

    @ResponseBody
    @PostMapping("/memeber")
    public String post_memeber(@RequestBody String data){
        System.out.println(data + "를 받았습니다");
        return "DATA-OK.!";
    }

//    @GetMapping("/main")
//    public void get_main() {
//
//    }
//
//    @GetMapping("/error")
//    public void get_error() {
//
//    }
//
//    @GetMapping("/logins")
//    public void get_logins(){}
//
//    @GetMapping("/board")
//    public void get_board(){}

}