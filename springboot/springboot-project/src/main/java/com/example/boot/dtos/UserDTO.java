package com.example.boot.dtos;

import lombok.*;

import java.time.LocalDate;

// DB 테이블 하나 당 필요

@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String pw;
    private String nickName;
    private LocalDate registerDate;
}