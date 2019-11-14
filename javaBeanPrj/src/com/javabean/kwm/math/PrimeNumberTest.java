package com.javabean.kwm.math;

import jdk.nashorn.internal.ir.Flags;

import java.awt.*;

/**
 * 100以内所有质数的输出
 * 质数：素数，只能被1和本身整除的自然数<--> 从2开始，到本身-1 ，都不能被本身整除
 * 注：return是专门结束方法的，并非专门用于结束循环的。
 *    2 是最小的质数。
 */
public class PrimeNumberTest {
    public static void main(String[] args) {
        //
        PrimeNumberTest primeNumberTest = new PrimeNumberTest();
        primeNumberTest.test3();
    }

    //第一种输出质数方法
    public void test1(){
        boolean isFlag = true;
        for(int i = 2;i <= 100;i++){
            for (int j = 2;j < i;j++){
                if ( i % j == 0){
                    isFlag = false;
                    break;
                }
            }

            if (isFlag){
                System.out.println(i);
            }
            //重置isFlag
            isFlag = true;
        }
    }

    //通过优化质数的范围 连增加效率
    public void test2(){
        boolean isFlag = true;
        for(int i = 2;i <= 100000;i++){
            //通过根号开方缩减循环范围， Math.sprt()表示取根号，
            //对本身是质数的自然数是有效的
            for (int j = 2;j <= Math.sqrt(i);j++){
                if ( i % j == 0){//i被j除尽
                    isFlag = false;
                    break;//对本身非质数的自然数有效，可以直接跳出。
                }
            }

            if (isFlag){
                System.out.println(i);
            }
            //重置isFlag
            isFlag = true;
        }
    }


    //通过优化质数的范围 连增加效率
    public void test3(){
        boolean isFlag = true;
        int count = 0;
        long start = System.currentTimeMillis();
        for(int i = 2;i <= 100000;i++){
            //通过根号开方缩减循环范围， Math.sprt()表示取根号，
            //对本身是质数的自然数是有效的
            for (int j = 2;j <= Math.sqrt(i);j++){
                if ( i % j == 0){//i被j除尽
                    isFlag = false;
                    break;//对本身非质数的自然数有效，可以直接跳出。
                }
            }

            if (isFlag){
//                System.out.println(i);
                count++;
            }
            //重置isFlag
            isFlag = true;

        }
        long end = System.currentTimeMillis();
        System.out.println("质数的个数是：" +count);
        System.out.println("所花费的是时间是：" + (end-start));
    }

    //通过优化质数的范围 连增加效率
    public void test4(){
        int count = 0;
        long start = System.currentTimeMillis();
        Label:for(int i = 2;i <= 100000;i++){
            //通过根号开方缩减循环范围， Math.sprt()表示取根号，
            //对本身是质数的自然数是有效的
            for (int j = 2;j <= Math.sqrt(i);j++){
                if ( i % j == 0){//i被j除尽
                    continue Label;
                }
            }
            count++;
        }
        long end = System.currentTimeMillis();
        System.out.println("质数的个数是：" +count);
        System.out.println("所花费的是时间是：" + (end-start));
    }
}
