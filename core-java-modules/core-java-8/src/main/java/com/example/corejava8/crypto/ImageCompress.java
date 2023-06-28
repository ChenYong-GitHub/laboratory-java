package com.example.corejava8.crypto;

import cn.hutool.crypto.digest.DigestUtil;

import java.io.File;

public class ImageCompress {

    public static void main(String[] args) {
        String url = "C:\\Users\\26069\\Pictures\\giphy.gif";
        File file = new File(url);
        try {
            long l1 = System.currentTimeMillis();
            String h1 = DigestUtil.sha256Hex(file);
            long l2 = System.currentTimeMillis();
            String h2 = DigestUtil.md5Hex(file);
            long l3 = System.currentTimeMillis();
            System.out.println(l2 - l1);
            System.out.println(l3 - l2);
            System.out.println(h1);
            System.out.println(h2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
