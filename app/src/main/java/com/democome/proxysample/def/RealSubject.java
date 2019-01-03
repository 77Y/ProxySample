package com.democome.proxysample.def;

public class RealSubject implements Subject {
    @Override
    public void operation() {
        System.out.println("我是真实操作");
    }

    @Override
    public void operation2() {
        System.out.println("我是真实操作2");
    }
}
