package com.example.boot.controller;

import com.example.boot.dtos.UserDTO;
import com.example.boot.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserContoller {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/login")
    public void get_user_login(){

    }

    @PostMapping("/login") //매핑대상: /user/login
    public String post_user_login(UserDTO userDTO){ // => form에서 전달한 UserDTO
        System.out.println("전달받은 userDTO: " + userDTO);
        // 전달받은 id를 DB에 전달하여 SELECT 한 결과인 UserDTO 객체를 받아온다
        // DB에서 전달한 UserDTO
        UserDTO user = userMapper.get_user(userDTO.getId() , userDTO.getPw());
        // DB에서 SELECT가 되었나? => user가 null인가?
        if(user == null){ // 해당 정보로 유저를 못찾았다
            return "redirect:/user/login"; // 로그인창으로 다시 이동!
        }else{ // 해당 정보로 유저를 찾았다
            return "redirect:/board/main"; // Board Main으로 이동!
        }
    }

    @GetMapping("/register")
    public void get_user_register(){}

    @PostMapping("/register")
    public String post_user_register(UserDTO userDTO, RedirectAttributes redirectAttributes){
        UserDTO existIDDTO = userMapper.is_user_exist(userDTO.getId(), null);
        UserDTO existNickDTO = userMapper.is_user_exist(null, userDTO.getNickName());
        if(existIDDTO == null && existNickDTO == null){ //DB에 일치하는 정보가 없었음
            userMapper.insert_user(userDTO);
            return "redirect:/user/login";
        }
        if(existIDDTO != null){
            redirectAttributes.addFlashAttribute("idMessage", "ID가 중복입니다");
        }
        if(existNickDTO != null){
            redirectAttributes.addFlashAttribute("nickMessage", "NickName이 중복입니다");
        }
        return "redirect:/user/register";
    }
//    @Autowired
//    private UserMapper userMapper;
//
//    @GetMapping("/login")
//    public void get_user_login() {
//
//    }
//
//    // @PostMapping("/user/login")
//    // 매핑 대상 : /user/login
//    @PostMapping("/login")
//    public String post_user_login(UserDTO userDTO) {
//        // 매개변수로 받은 UserDTO : form에서 전달한 UserDTO
//        // jsp의 input name과 파라미터 UserDTO 내의 인스턴스 이름이 같으면 자동으로 매핑
//        System.out.println("log : Passed Object " + userDTO);
//
//        // 전달받은 id를 DB에 전달하여 SELECT한 결과인 UserDTO 객체를 받아옴
//        // DB에서 전달한 UserDTO
//        UserDTO user = userMapper.get_user(userDTO.getId(), userDTO.getPw());
//
//        // DB에서 SELECT 문이 정상적으로 실행되었다면
//         if(user == null) {
//            // 해당 정보로 유저 정보 조회 실패 (로그인 실패)
//            // 로그인 창으로 되돌아감 (post 요청이므로 되돌아가도록 하는 걸 권장-)
//             System.out.println("login is successful.");
//            return "redirect:/user/login";
//         }
//         else {
//            // 해당 정보로 유저 정보 조회 성공 (로그인 성공)
//            // board 의 main.jsp로 이동
//             System.out.println("login is failed.");
//
//            return "redirect:/board/main";
//         }
//    }
//
//    @GetMapping("/register")
//    public void get_user_register() {
//
//    }
//
//    @PostMapping("/register")
//    public String post_user_register(UserDTO userDTO, RedirectAttributes redirectAttributes) {
//        UserDTO existIdDTO = userMapper.is_user_exist(userDTO.getId(), null);
//        UserDTO existNicknameDTO = userMapper.is_user_exist(null, userDTO.getNickname());
//        String message = "";
//        if(existIdDTO == null && existNicknameDTO == null) {
//            // 중복되는 사용자 없음
//            // 사용자 정보 INSERT
//            userMapper.insert_user(userDTO);
//            return "redirect:/user/login";
//        }
//        if(existIdDTO != null) {
//            message = "Id is duplcated.";
//        } else if(existNicknameDTO != null) {
//            message = "Nickname is duplicated.";
//        }
//        redirectAttributes.addAttribute("message", "Info duplication is accured.");
//        return "redirect:/user/register";
//    }
}