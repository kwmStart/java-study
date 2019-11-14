package com.javabean.kwm.math;

/**
 * 一个数如果切好等于它的因子之和，这个数就称为“完数”。例如：6=1+2+3
 * 编程：找出1000以内的所有完数。
 * 因子：除去这个数本身的其他约数
 */
public class WanShuTest {

    public static void main(String[] args) {
        int sumYinZi;
        //遍历1000个自然数
        for (int i = 0;i <= 1000;i++){
            sumYinZi = 0;
            for(int j = 1; j <= i/2 ;j++){//j<(i/2) 为了提升效率性能，只要j<i/2 既可以判断出其所有的因子
                if (i % j == 0){
                    sumYinZi += j;
                }

            }
            //判断其是否为完数
            if (i == sumYinZi) {
                System.out.println("完数：" + i);
            }

        }
    }
}
