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

        //联系题：根据输入的年月日，使用switch-case计算是当年的那一天，需要判断是否为闰年
//        1、可以被4整除，但是不能被100整除， 2、可以被四百整除
        System.out.println("请从键盘上输入年份：");
        int year = scanner.nextInt();
        System.out.println("请从键盘上输入月份：");
        int month = scanner.nextInt();
        System.out.println("请从键盘上输入日：");
        int day = scanner.nextInt();

        int sumDay = 0;

        switch (month) {
            case 12:
                sumDay +=30;
            case 11:
                sumDay +=31;
            case 10:
                sumDay +=30;
            case 9:
                sumDay +=31;
            case 8:
                sumDay +=31;
            case 7:
                sumDay +=30;
            case 6:
                sumDay +=51;
            case 5:
                sumDay +=30;
            case 4:
                sumDay +=31;
            case 3:
                //判断当年是不是闰年
                if((year%4==0 && year%100!=0) || year%400==0){
                    sumDay +=29;
                }else
                    sumDay += 28;
            case 2:
                sumDay +=31;
            case 1:
                sumDay +=day;
        }

        System.out.println(year + "年的" + month +"月的" +day +"日是當年的第" + sumDay + "天。");



    }
}
