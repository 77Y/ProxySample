package com.democome.proxysample.def;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String args[]) {

//        Subject subject = new RealSubject();
//        Subject proxy = new StaticProxy(subject);
//        proxy.operation();
//        proxy.operation2();


        Subject subject1 = new RealSubject();
        DynamicProxy handler = new DynamicProxy(subject1);
        Subject proxy1 = (Subject) Proxy.newProxyInstance(subject1.getClass().getClassLoader(), subject1.getClass().getInterfaces(), handler);
        proxy1.operation();
        proxy1.operation2();

    }
}
