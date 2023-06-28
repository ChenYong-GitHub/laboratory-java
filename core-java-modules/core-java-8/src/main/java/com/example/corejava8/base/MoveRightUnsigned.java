package com.example.corejava8.base;

public class MoveRightUnsigned {

    public static void main(String[] args) {
        int a = 0xff00ff; // 十六进制表示的整数
        int b = a >>> 8; // 将a向右移动8位，得到无符号右移的结果

        System.out.println("a = " + Integer.toBinaryString(a)); // 输出a的值
        System.out.println("b = " + Integer.toBinaryString(b)); // 输出无符号右移后的结果

    }
}
