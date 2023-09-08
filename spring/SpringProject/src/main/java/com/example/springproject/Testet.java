package com.example.springproject;

class A {

}

class B {
    B b = new B();
}

public class Testet {
    private A a = new A();
    // 의존성 : Testet 클래스는 A 클래스에 의존한다. 결합도가 낮을수록 유지보수가 쉬움.
    // 의존성 주입 (DI) :
}
