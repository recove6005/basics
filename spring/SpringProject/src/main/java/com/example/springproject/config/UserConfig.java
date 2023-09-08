package com.example.springproject.config;

import com.example.springproject.annotation.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    User getUser() {
        return new User("lee", "Deagu");
    }
}
