package com.example.springproject.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main() {
        System.out.println();
        return "test/main";
    }

    @GetMapping("/maincontrol")
    public String main2() {
        System.out.println("/maincontrol is excuted.");
        return "redirect:/views/main.jsp";
    }
}
