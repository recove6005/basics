package com.example.springproject.mvc.controller;

import com.example.springproject.mvc.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
public class BoardController {

//      HttpSession 으로 작업, id = korea / pw = a123, nickname=korea

//      /main/board (GET) -> 로그인 되어있는 상태라면 들어오기
//		  -> 로그인 되어있지 않다면 /user/login으로

//      /user/login (GET)  -> 로그인 되어있음 -> /main/board 로 이동
//		  -> 로그인 안 되어있음 -> /user/login 창으로

//      /user/login (POST) -> logic 처리 후 /main/board 로 -> nickname 출력
//	    /main/login/ 으로 가기 -> "Worong id or password." 출력

    String id = "korea";
    String pw = "a123";

    @GetMapping("/main/board")
    public String get_board(HttpSession session){
        // 로그인이 되어있을 때
        if(session.getAttribute("user") != null){
            return "/main/board";
        }
        return "redirect:/user/login";
    }

    @GetMapping("/user/login")
    public String get_user(
            RedirectAttributes redirectAttributes,
            HttpSession session,
            String message
    ){
        // 로그인이 되어있을 때
        if(session.getAttribute("user") == null){
            return "redirect:/main/board";
        }

        // 로그인 실패
        if(message != null) {
            redirectAttributes.addAttribute("message", message);
        }
        return "/user/login";
    }

    // 로그인 시도
    @PostMapping("/user/login")
    public String post_user(
            RedirectAttributes redirectAttributes,
            HttpSession session,
            UserVO vo
    ){
        if(id.equals(vo.getId()) && pw.equals(vo.getPw())) {
            vo.setNickName("korea");
            session.setAttribute("user", vo);
            return "redirect:/main/board";
        }

        redirectAttributes.addFlashAttribute("message", "Worong ID or password.");
        return "redirect:/user/login";
    }
}