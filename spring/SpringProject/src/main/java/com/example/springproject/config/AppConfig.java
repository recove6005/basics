package com.example.springproject.config;

import com.example.springproject.test.Computer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Computer computer() {
        return new Computer("Mac", 1000000);
    }
    // @Bean(initMethod = "init_test_method")
    // public User spring_user() {
    //    return new User("Spring user", 20, computer());
    // }

    // @Bean(initMethod = "init_test_method")
    // public User servlet_user() {
    //     return new User("Servlet user", 20, computer());
    // }
}