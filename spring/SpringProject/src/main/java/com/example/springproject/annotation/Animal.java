package com.example.springproject.annotation;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter // 게터 생성
@Setter // 세터 생성
@ToString
@AllArgsConstructor // 모든 생성자 생성
@NoArgsConstructor
@Component
public class Animal {
    @Value("동물")
    private String type;
    @Value("2")
    private int age;
}
