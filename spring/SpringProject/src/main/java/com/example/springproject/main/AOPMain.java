package com.example.springproject.main;

import com.example.springproject.aop.Calculator;
import com.example.springproject.config.AOPConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
        Calculator calculator = context.getBean(Calculator.class);

        calculator.add(2, 5);
    }
}
