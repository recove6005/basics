package com.example.springproject.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BoardLogin {
    @Before("execution(void com.example.springproject.aop.Calculator.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("==== logBefore ====");
        System.out.println("실행이 끝난 메소드 " + joinPoint.getSignature().getName());
    }
}
