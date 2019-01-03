package com.democome.proxysample.def;

public class StaticProxy implements Subject {

    private Subject realSubject;

    public StaticProxy(Subject subject) {
        this.realSubject = subject;
    }

    @Override
    public void operation() {
        System.out.println("我是代理操作");
        realSubject.operation();
    }

    @Override
    public void operation2() {
        System.out.println("我是代理操作2");
        realSubject.operation();
    }
}
