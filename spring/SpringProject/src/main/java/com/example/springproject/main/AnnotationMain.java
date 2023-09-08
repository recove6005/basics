package com.example.springproject.main;

import com.example.springproject.annotation.User;
import com.example.springproject.config.UserConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.springproject.annotation")
public class AnnotationMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        User user = context.getBean(User.class);
        user.execute();
        context.close();


    }
}