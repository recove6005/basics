package com.example.springproject.annotation;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
@Primary
@DependsOn

public class Person {
    @Value("사람")
    String name;
    @Autowired(required = false) //필드 주입
    Animal animal;
    public void init() {
        System.out.println("Welcom - !");
    }

    public void destroy() {
        System.out.println("Destroyed - !");
    }


}
