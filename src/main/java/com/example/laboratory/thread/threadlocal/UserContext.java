package com.example.laboratory.thread.threadlocal;

import lombok.Data;

@Data
public class UserContext {
    private String userName;

    public UserContext(String userName) {
        this.userName = userName;
    }

}
