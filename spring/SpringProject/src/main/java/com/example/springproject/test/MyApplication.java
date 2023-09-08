package com.example.springproject.test;

import com.example.springproject.annotation.User;
import com.example.springproject.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplication {
    public static void main(String[] args) {
        // Bean 획득하기
        // context 객체 가져오기
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(annotationContext);
        // User user = annotationContext.getBean(User.class);
        // System.out.println(user);

        User user1 = annotationContext.getBean("spring_user", User.class);
        User user2 = annotationContext.getBean("servlet_user", User.class);
        System.out.println(user1);
        System.out.println(user2);

        // /resources/applicationContext.xml에 정의한 context
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user3 = xmlContext.getBean("xml_user", User.class);
        System.out.println(user3);

        System.out.println("=== Data GET ===");
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

        System.out.println("=============================");
        // Computer computer = user1.getComputer();
        // computer.setOs("new Mack!");
        // System.out.println(user2.getComputer());

        MyCollection collection = xmlContext.getBean(MyCollection.class);
        System.out.println(collection.getArrayList());
        System.out.println(collection.getHashSet());
        System.out.println(collection.getHashMap());
        System.out.println(collection.getProperties());

    }
}