package com.javabean.kwm.parameters;

import java.util.Arrays;

/**
 * @ClassName ParametersMathTest
 * @Description 参数传递机制练习
 * @Author kwm
 * @Date 2020/5/28 8:58
 */
public class ParametersMathTest {

    public static void main(String[] args) {
        int i = 1;
        String str = "Hello ";
        Integer num = 2;
        int[] arr = {1,2,3,4,5};
        MyData m = new MyData();

        change(i,str,num,arr,m);

        System.out.println("i = " + i);
        System.out.println("str = " + str);
        System.out.println("num = " + num);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("m.a = " + m.a);

        // i=1
        // str = Hello  由于字符串的不可变性 在change方法中s += "World"; 相当于开辟 "Hello " ,"World" 产生"Hello World"
        //               从而使得s的物理地址发生改变
        // num = 200   同理，num属于封装类变量
        // arr[]={2,2,3,4,5}
        // m.a = 11
        /*
          方法参数的传递机制：
          一、形参是基本数据类型的传递： 传递的是数值。
          二、参数是引用数据类型的：
              传递的是地址值。
              特殊的类型：String、包装类等对象的不可变性。

          实参给形参赋值时：
            基本数据类型：数值
            引用数据类型：物理地址值
         */
    }

    public static void change(int j,String s,Integer n,int[] a,MyData m){
        j += 1;
        s += "World";
        n += 1;
        a[0] += 1;
        m.a += 1;
    }
}

class MyData {
    int a = 10;
}
