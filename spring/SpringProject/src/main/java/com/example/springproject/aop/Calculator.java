package com.example.springproject.aop;

import org.springframework.stereotype.Component;

// Target 클래스
@Component
public class Calculator {
    public void add(int x, int y) {
        System.out.println(x + y);
    }
    public void sub(int x, int y) {
        System.out.println(x - y);
    }
    public void divide(int x, int y) {
        System.out.println(x / y);
    }
}
