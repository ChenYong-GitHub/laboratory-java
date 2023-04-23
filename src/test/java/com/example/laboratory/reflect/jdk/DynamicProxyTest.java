package com.example.laboratory.reflect.jdk;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class DynamicProxyTest {

    @Test
    public void test1() {
        DynamicInterfaceImpl target = new DynamicInterfaceImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(target);
        DynamicInterface dynamicInterfaceProxy = (DynamicInterface) dynamicProxy.getProxyInstance();
        dynamicInterfaceProxy.eat("张三", 18);
    }


    @Test
    public void test2() {
        int i = 3 << 4;  // 3 * 2^4 = 48
        BigDecimal j = new BigDecimal(3 >> 4);
        System.out.println("3左移4位：" + i);
        System.out.println("3右移4位：" + j);
    }
}
