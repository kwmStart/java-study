package com.javabean.kwm.jdk8.impl;

import com.javabean.kwm.jdk8.CompareA;
import com.javabean.kwm.jdk8.CompareB;

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

        // 知识点3： 如果子类（实现类）继承的父类和实现的接口中声明了同名同参数的方法，
        // 那么子类在没有重写此方法的情况下，默认调用的时父类中的同名同参数的方法。 --> 类优先原则
        // 知识点4： 如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，
        // 那么在实现类没有重写此方法的情况下，报错 -->接口冲突。
        // 这就需要我们必须重写此方法。
        subClass.method3();
    }

}

class SubClass extends SuperClass implements CompareA, CompareB {

    @Override
    public void method2() {
        System.out.println("SubClass: 我是子类实现的接口中的默认方法method2的重写");
    }

    @Override
    public void method3() {
        System.out.println("SubClass: 我是实现类中的method3方法，我是重写的默认方法");
    }


}
