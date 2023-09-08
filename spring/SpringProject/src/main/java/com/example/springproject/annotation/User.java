package com.example.springproject.annotation;

import com.example.springproject.test.Computer;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// @Scope("prototype")
// @PropertySource("classpath:user.properties")
public class User {
    // @Value("${name}")
    private String name;
    // @Value("${addr}")
    private String addr;
    // @Value("${step}")
    // private String step;
    // private int age;
    // private Computer computer;

    public void execute() {
        System.out.println("User is executed.");
    }

    public void init_test_method() {
        System.out.println("My name is " + name + ".");
    }
}
