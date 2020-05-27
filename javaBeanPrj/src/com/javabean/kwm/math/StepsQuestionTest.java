package com.javabean.kwm.math;

/**
 * @ClassName StepsQuestionTest 台阶问题
 * @Description 面试题，有n步台阶，一次只能走一步或者两步，共有多少种走法？  尝试使用循环迭代和递归解题
 * @Author kwm
 * @Date 2020/5/27 13:20
 */
public class StepsQuestionTest {

    public static void main(String[] args) {
        //递归
        Recursion recursion = new Recursion();
        System.out.println(recursion.getSteps(5));
        //优点：代码简洁，可读性高 缺点：浪费空间，递归太深可能导致堆栈溢出

        //循环迭代
        IterationAndLoop loop = new IterationAndLoop();
        System.out.println(loop.getSteps(5));
        //优点：代码执行效率高，不增加额外空间开销。 缺点：不如递归的代码可读性好。
    }
}


/**
 * IterationAndLoop循环迭代
 *
 * 当n等于一的时候 只有走一步这种情况，当n=2时 可以一步一步，也可以直接两步上去。
 * 当n=3， ①、执行f(1)走到相应台阶； 然后从f(1)台阶直接两步走完。
 *         ②、执行f(2)走到相应台阶； 然后从f(2)台阶直接一步走完。
 * 当n=4, ①、执行f(2)走到相应台阶； 然后从f(2)台阶直接两步走完。
 *        ②、执行f(3)走到相应台阶； 然后从f(3)台阶直接一步走完。
 * n=1,     f(1) = 1;
 * n=2,     f(2) = 2;
 * n=3,     f(3) = f(1) + f(2);
 *                 stepTwo =f(1);stepOne= f(2);
 *                 stepTwo + stepOne
 * n=4,     f(4) = f(2) + f(3);
 *                 stepTwo =f(2);stepOne= f(3);
 *                 stepTwo + stepOne
 * n=x      f(x) = f(x-2) + f(x-1);
 *                 stepTwo =f(x-1);stepOne= f(x-2);
 *                 stepTwo + stepOne
 */
class IterationAndLoop {

    public int getSteps(int n){
        if (n<1){
            throw new IllegalArgumentException(n +"为不合法参数！");
        }
        if (n==1 || n ==2){
            return n;
        }
        //初始化为走到第二阶台阶走的情况
        int stepOne = 2;
        //初始化为走到第一阶台阶走的情况
        int stepTwo = 1;
        int sum = 0;
        for (int i=3;i<=n;i++){
            //最后跨出去两步走法+最后跨一次的走法
            sum = stepTwo + stepOne;
            stepTwo = stepOne;
            stepOne = sum;
        }
        return sum;

    }
}


/**
 * 递归
 * 当n等于一的时候 只有走一步这种情况，当n=2时 可以一步一步，也可以直接两步上去。
 * 当n=3，先到达第二级台阶,剩余一步,执行f(1)种情况； 先到达第一级台阶,剩余两步，执行f(2)种情况。
 * 当n=4, 先到达第二级台阶,剩余两步步,执行f(2)种情况； 先到达第一级台阶,剩余三步，执行f(3)种情况。
 *
 * 或者理解为：
 *  当n等于一的时候 只有走一步这种情况，当n=2时 可以一步一步，也可以直接两步上去。
 * 当n=3， ①、执行f(1)走到相应台阶； 然后从f(1)台阶直接两步走完。
 *         ②、执行f(2)走到相应台阶； 然后从f(2)台阶直接一步走完。
 * 当n=4, ①、执行f(2)走到相应台阶； 然后从f(2)台阶直接两步走完。
 *        ②、执行f(3)走到相应台阶； 然后从f(3)台阶直接一步走完。
 * n=1,     f(1) = 1;
 * n=2,     f(2) = 2;
 * n=3,     f(3) = f(1) + f(2);
 * n=4,     f(4) = f(2) + f(3);
 * ...
 * n=x      f(x) = f(x-2) + f(x-1);
 */
class Recursion {

    public int getSteps(int n){
        if (n<1){
            throw new IllegalArgumentException(n +"为不合法参数！");
        }
        if (n==1 || n ==2){
            return n;
        }
//        if (n>=3){
        return getSteps(n-2) + getSteps(n-1);
//        }
    }
}
