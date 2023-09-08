package com.example.springproject.main;

import com.example.springproject.config.ScopeConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Locale;

public class ScopeMain {
    @Value("classpath:data")
    private static Resource resource;
    public static void main(String[] args) throws IOException {
        // Files.lines(Paths.get(resource.getURI()), Charset.forName("UTF-8")).forEachOrdered(System.out::println);

        ApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        String computer = context.getMessage("computer", null, Locale.US);
        String coffee = context.getMessage("coffee", null, Locale.US);
        String phone = context.getMessage("phone", null, Locale.US);
        String introduce = context.getMessage("introduce", new Object[] {"ko", "order"}, Locale.US);

        System.out.println(computer);
        System.out.println(coffee);
        System.out.println(phone);
        System.out.println(introduce);
    }
}
