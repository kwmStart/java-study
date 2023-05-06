package com.javabean.kwm.jdk8.impl;

/**
 * @ClassName SuperClass
 * @Description 测试父类中的存在与实现的接口中同名同参方法
 * @Author kwm
 * @Date 2023/4/18 22:00
 */
public class SuperClass {

    /**
     * 与实现类中同名同参的方法
     */
    public void method3() {
        System.out.println("SuperClass: 我是父类中的方法method3，与实现接口中的默认方法同名同参");
    }
}
