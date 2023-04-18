package com.javabean.kwm.jdk8.impl;

import com.javabean.kwm.jdk8.CompareA;

/**
 * @ClassName SubClassTest
 * @Description 子类集成接口 测试类
 * @Author kwm
 * @Date 2023/4/18 21:50
 */
public class SubClassTest {


    public static void main(String[] args) {
        SubClass subClass = new SubClass();

//        subClass.method1();
//        SubClass.method1();
        // 知识点1：接口中定义的静态方法，只能通过接口来调用。
        CompareA.method1();
        // 知识点2：通过实现类的对象，可以调用接口中的默认方法。
        // 如果实现类重写了接口中的默认方法，调用时 ，仍然是调用重写以后的方法。
        subClass.method2();
//        SubClass.method2();

        // 知识点3： 如果子类（实现类）继承的父类和实现的接口中声明了同名同参数的方法，
        // 那么子类在没有重写此方法的情况下，默认调用的时父类中的同名同参数的方法。 --> 类优先原则
        subClass.method3();
    }

}

class SubClass implements CompareA {

    @Override
    public void method2() {
        System.out.println("SubClass: 我是子类实现的接口中的默认方法method2的重写");
    }
}
