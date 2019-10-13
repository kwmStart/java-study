package com.javabean.kwm.ysf;

public class YsfTest01 {
    public static void main(String[] args) {
        short s1 = 10;
        System.out.println(s1 + 1);
        s1 = (short) (s1 + 1);
        //自增1不会改变本身变量的类型。
        System.out.println(s1++);

        System.out.println(s1+=1);

        s1 = s1+=1;
        System.out.println(s1 + " =============");

        byte b1 = 127;
        b1++;
        System.out.println(b1);//-128
    }
}
