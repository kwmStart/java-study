package com.javabean.kwm.jdk8;

/**
 * @ClassName CompareB
 * @Description 测试同时实现两个同名default方法问题
 * @Author kwm
 * @Date 2023/4/20 21:22
 */
public interface CompareB {

    /**
     * 默认方法不带声明
     */
    default void method3() {
        System.out.println("CompareB: 我是CompareB接口中的默认方法method3");
    }
}
