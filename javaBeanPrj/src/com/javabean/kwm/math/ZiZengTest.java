package com.javabean.kwm.math;

/**
 * @ClassName ZiZengTest
 * @Description 自增长练习,运算符计算
 * @Author kwm
 * @Date 2020/5/26 15:05
 */
public class ZiZengTest {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        // i =  4;
        // j =  1;
        // k = 11;
        /*
         赋值= 最后计算
         =右边的从左到右加载值依次压入操作数栈
         实际先算那个根据运算符优先级确认
         自增自减操作都是直接操作变量的值，不经过操作数栈。
         最后赋值之前，临时结果也存储在操作数栈

                   局部变量                操作数栈(运算在操作数栈进行)
          int i=1  i=1
          ----------------------------------------
          i=i++
                   i=1                    i=1
            i++    i=2                    i=1
           i=i++   i=1
          ----------------------------------------
          int j=i++
                  j=                      i=1
             i++  i=2                     i=1
           j=i++  j=1
                  i=2
          ----------------------------------------
          int k = i + ++i*  i++;
                  k=                      i=2
            ++i   k=
                  i=3                     3
            i++   i=4                     3
        ++i * i++                         3*3=9
    i + ++i*  i++                         2+9 = 11
                  k=11
          */

    }
}
