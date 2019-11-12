package com.javabean.kwm.math;

/**
 * 测试random的随机数 取[a,b]
 * 公式：(int) (Math.random()* ( b - a + 1) + a)
 */
public class MathRandomTest {

    public static void main(String[] args) {
        //获取一个两位数的随机数 10-99
        for (int i = 0 ; i < 20; i++){
            int value = (int) (Math.random()*(99 - 10 + 1) + 10);
            System.out.println(value);
        }
    }
}
