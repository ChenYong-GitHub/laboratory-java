package com.example.laboratory.thread.threadlocal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SharedMapWithUserContext implements Runnable{

//    public static Map<Integer, UserContext> userContextPerUserId = new ConcurrentHashMap<>();

    public static ThreadLocal<UserContext> userContext = new ThreadLocal<>();
    private Integer userId;
    private UserRepository userRepository = new UserRepository();

    @Override
    public void run() {
        String userName = userRepository.getUserNameForUserId(userId);
//        userContextPerUserId.put(userId, new UserContext(userName));

        userContext.set(new UserContext(userName));
//        System.out.println("userName:" + userName);
        System.out.println(userName + "currentTheadName:" + Thread.currentThread().getName());
        System.out.println("thread context for given userId: " + userId + " is: " + userContext.get());
    }



    public SharedMapWithUserContext(Integer userId) {
        this.userId = userId;
    }
}
