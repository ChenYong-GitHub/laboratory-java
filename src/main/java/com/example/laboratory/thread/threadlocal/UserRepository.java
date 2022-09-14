package com.example.laboratory.thread.threadlocal;

public class UserRepository {

    public String getUserNameForUserId(Integer userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId can not be null");
        }
        if (userId == 1) {
            return "至尊宝";
        }
        if (userId == 2) {
            return "紫霞";
        }
        return "There is no such user";
    }
}
