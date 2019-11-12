package com.javabean.kwm.scanner;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请从键盘上输入你的姓名：");
        String name = scanner.next();
        System.out.println(name);
        System.out.println("请输入你的性别：");
        String sex = scanner.next();
        char sex1 = sex.charAt(0);
        System.out.println(sex1);
    }
}
