package com.example.laboratory.thread.threadlocal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadLocalTest {

    @Test
    public void test1() {

        SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
        SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);

        new Thread(firstUser).start();
        new Thread(secondUser).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        int size = SharedMapWithUserContext.userContextPerUserId.size();
        UserContext userContext = SharedMapWithUserContext.userContext.get();
//        System.out.println(userContext);
        System.out.println("currentTheadName:" +Thread.currentThread().getName());
//        System.out.println(String.format("the size of map: %s", size));
//
//        assertEquals(size, 2);
    }

}
