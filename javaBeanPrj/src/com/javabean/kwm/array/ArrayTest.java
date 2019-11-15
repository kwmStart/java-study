package com.javabean.kwm.array;

public class ArrayTest {
    public static void main(String[] args) {
        String[][] arr1 = new String[3][];

        System.out.println(arr1[0]); //输出是一个null
//        System.out.println(arr1[3]);//数组下标越界
//        System.out.println(arr1[2][1]);//空指针异常

        String[][] arr2 = new String[3][1];

        System.out.println(arr2[0]); //输出是一个地址值
    }
}
