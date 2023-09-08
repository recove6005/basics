package com.example.springproject.mvc.vo;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private String name;
    private int age;
    private String nickName;
    private LocalDate birth; // 생년월일
    private String id;
    private String pw;
}
