package com.javabean.kwm.jdk8;

/**
 * @ClassName CompareA
 * @Description 测试jdk1.8的静态方法和默认方法
 * 静态方法 static  默认方法 default
 * @Author kwm
 * @Date 2023/4/18 21:44
 */
public interface CompareA {

    /**
     * 静态方法测试
     */
    public static void method1() {
        System.out.println("CompareA: 我是接口中的静态方法。");
    }

    /**
     * 默认方法带声明
     */
    public default void method2() {
        System.out.println("CompareA: 我是接口中的默认方法method2");
    }

    /**
     * 默认方法不带声明
     */
    default void method3() {
        System.out.println("CompareA: 我是接口中的默认方法method3");
    }



}
