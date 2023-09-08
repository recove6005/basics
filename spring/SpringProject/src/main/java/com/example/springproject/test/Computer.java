package com.example.springproject.test;

import org.springframework.stereotype.Component;


@Component
public class Computer {
    String os;
    int price;

    public String getOs() {
        return os;
    }

    public int getPrice() {
        return price;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Computer(String os, int price) {
        this.os = os;
        this.price = price;
    }
}
