package com.example.springdbproejct.restController;

import com.example.springdbproejct.dtos.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

// 자료 전달만을 담당하는 컨트롤러라면
// @RestController 어노테이션 사용
// 모든 메소드에 @ResponseBody를 자동으로 달아줌

@Controller
@RequestMapping("/rest")
public class RestTestController {
    @ResponseBody
    @GetMapping("/message")
    public String get_message(@RequestParam String data) {
        // @ResponseBody 어노테이션
        // "This is message." 라는 jsp를 찾아가지 않고 String을 반환
        return "This is message. : " + data;
    }

    @ResponseBody
    @GetMapping("/number")
    public int get_number() {
        return 123; // 123 반환
    }

    @ResponseBody
    @GetMapping("/user")
    public UserDTO get_user() {
        // ResponseBody 어노테이션 사용 시
        // 객체를 전달하면 JSON 형태로 반환
        return new UserDTO("korea", "a123", "코리아", LocalDate.now());
    }

    @ResponseBody
    @PostMapping("/user")
    public void get_user(@RequestBody UserDTO userDTO) {
        // UserDTO를 JSON 형태로 전달받을 시 값을 받지 못함
        // form 없이 input 작성
        System.out.println("Rest로 받은 객체 : " + userDTO);
    }

    @ResponseBody
    @GetMapping("/users")
    public List<UserDTO> get_users() {
        List<UserDTO> users = Arrays.asList(
                new UserDTO("korea", "a123", "코리아", LocalDate.now()),
                new UserDTO("korea", "a123", "코리아", LocalDate.now()),
                new UserDTO("korea", "a123", "코리아", LocalDate.now()),
                new UserDTO("korea", "a123", "코리아", LocalDate.now())
        );
        // 데이터 포맷 설정
        //
        return users;
    }


}
