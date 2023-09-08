package com.example.springdbproejct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/") // 맨 처음 홈페이지 접속 시 기본 페이지
    public String get_main() {
        // return "redirect:/user/login";
        // return "redirect:/file/upload";
        // return "/rest/main";
        return "/template/main";
    }
}