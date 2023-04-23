package com.example.laboratory.reflect.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy{

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        InvocationHandler h = (proxy, method, args) -> {
            System.out.println("before...");
            Object dynamicProxy = method.invoke(target, args);
            System.out.println("after...");
            return dynamicProxy;
        };
        Class<?> aClass = target.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), h);
    }

}
