package com.example.laboratory.reflect.jdk;

public class DynamicInterfaceImpl implements DynamicInterface {

    @Override
    public void eat(String name, Integer age) {
        System.out.println(String.format("%s，今年%s岁，吃了三斤螃蟹，四斤小龙虾", name, age));
    }

    public DynamicInterfaceImpl get() {
        return new DynamicInterfaceImpl();
    }
}