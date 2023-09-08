package com.example.springproject.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// Advice 클래스
@Aspect
@Component
public class Logging {
    @Before("execution(void com.example.springproject.aop.Calculator.*(..))")
    public void logBefore() {
        System.out.println("==== logBefore ====");
    }

    // 무조건 실행
    @After("execution(!void com.example.springproject.aop.Calculator.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("==== logAfter ====");
        System.out.println("실행이 끝난 메소드 " + joinPoint.getSignature().getName());
    }

    // 정상 종료일 경우에만 실행
    @AfterReturning(
            value = "execution(!void com.example.springproject.aop.Calculator.*(..))",
            returning = "data"
    )
    public void logAfterReturning(JoinPoint joinPoint, double data) {
        System.out.println("==== logAfterReturning ====");
        System.out.println("정상 실행이 끝난 메소드 : " + joinPoint.getSignature().getName());
        System.out.println("Retuned data : " + data);

    }

    // 정상 종료가 아닐 경우에만 실행
    @AfterThrowing(
            value = "execution(!void com.example.springproject.aop.Calculator.*(..))",
            throwing = "error"
    )
    public void logAfterThrowing(Exception error) {
        System.out.println("==== logAfterThrowing ====");

    }

    @Around(value = "execution(!void com.example.springproject.aop.Calculator.*(..))")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("==== logAround ====");
        System.out.println("Method starts : " + proceedingJoinPoint.getSignature().getName());
        Object[] objects = proceedingJoinPoint.getArgs();

        if((Integer)objects[1] == 0) {
            System.out.println(" 0 반환 ");
            return 0;
        }

        for(Object i : objects) {
            int data = (Integer)i;
            System.out.println("data : " + data);
        }

        try {
            Object result = proceedingJoinPoint.proceed(new Object[] {1, 2}); // 해당 메소드 실행
            System.out.println("Excution completed.");
            return result;
        } catch (Throwable e) {
            System.out.println("Error :: ");
            return e;
        }
    }
}