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

        //字符型的‘a’输出都为"a", 'a'的unicode为97
        char a = 'a';
        System.out.println(a);//a
        System.out.println(1+'a');//98
        System.out.println((char)97);//a

    }
}
