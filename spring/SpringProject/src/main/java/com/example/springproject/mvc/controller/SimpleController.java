package com.example.springproject.mvc.controller;

import com.example.springproject.mvc.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class SimpleController {
    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public void simple_get(@RequestParam(defaultValue = "0") int id,
                           @RequestParam String message) {
        System.out.println("simple get 실행");
        System.out.println("id : " + id);
        System.out.println("message : " + message);
    }

    @RequestMapping(value = "/simple", method = RequestMethod.POST, params = "!nickName")
    public void simple_post(
            @RequestParam(required = false) String nickName,
            @RequestParam(name="birth", required = false, defaultValue = "100") int age) {
        System.out.println("simple post 실행");
        System.out.println("age value : " + age);
        System.out.println("nickname value : " + nickName);

    }

    @GetMapping("/user")
    public String get_user() {
        return  "simple"; // View로 simple 을 선택
    }

    @PostMapping("/user")
    public String post_user(UserVO vo) {
        System.out.println("user - post execute.");
        System.out.println(vo);
        return "redirect:/simple?id=1&message=This is java";
    }

    @GetMapping("/model")
    public void model_get(Model model, String addr, String message) {
        model.addAttribute("addr", addr);
        model.addAttribute("message", message);
        model.addAttribute("password", 123);
    }

    @PostMapping("/model")
    public void post_user(HttpSession session,
                          @SessionAttribute(required = false) String sid,
                          @SessionAttribute(required = false) String spw,
                          String id,
                          String pw
                          ) {
        System.out.println(sid);
        System.out.println(spw);
        session.setAttribute("sid", id);
        session.setAttribute("spw", pw);
    }
}

