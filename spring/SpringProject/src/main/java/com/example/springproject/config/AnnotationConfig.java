package com.example.springproject.config;

import com.example.springproject.annotation.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.example.springproject.annotation")
@Configuration
public class AnnotationConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Person create_Pserson() {
        return null;
    }
}