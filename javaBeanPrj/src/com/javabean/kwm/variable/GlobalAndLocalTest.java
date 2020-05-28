package com.javabean.kwm.variable;

/**
 * @ClassName GlobalAndLocalTest
 * @Description 全局变量（成员变量）和局部变量
 * @Author kwm
 * @Date 2020/5/28 10:24
 */
public class GlobalAndLocalTest {
    /*
      一、就近原则
      二、变量分类： 成员变量（全局变量）：
                        类变量：
                        实例变量：
                    局部变量：
          成员变量和局部变量的区别
          ①、声明的位置
             局部变量：声明在方法体{}中，形参，代码块{}中.
             全局变量：类中方法体外。
                 类变量：有static修改.
                 实例变量：没有static修改.
          ②、修饰符
             局部变量：final
             全局变量：public、private、protected、final、static、volatile、transient
          ③、值存储位置
             局部变量：堆。
             全局变量：
                类变量：方法区
                实例变量：栈
          ④、作用域
             局部变量：从声明位置开始，到所属方法体结束。
             全局变量：
                类变量：在当前类中"类名."（有时类名.可以省略），其他类中"类名."或者"对象名."访问。
                实例变量：在当前类中"this."（有时this.可以省略），其他类中"对象名."访问。
          ⑤、声明周期
             局部变量：每一个线程每一次调用都是一个新的声明周期。
             全局变量：
                类变量：随着类的初始化而初始化，随着类的卸载而消亡，该类的所有对象的类变量都是共享的
                实例变量：随着对象的创建而初始化，随着对象的回收而消亡，每一个对象的实例变量都是独立存在的。
       三、非静态代码块的执行：每创建一次实例对象就要执行一次。
       四、方法的调用规则：调用一次执行一次。

       局部变量没有默认值，成员变量是有默认值的。
       栈中开辟空间是以方法为单位开辟空间。

     */
    /**成员变量的类变量*/
    static int s;
    /**成员变量的实例变量*/
    int i;
    /**成员变量的实例变量*/
    int j;

    {
        //作用域只在当前代码块 局部变量
        int i = 1;
        //i变量就近原则， 如果是this.i就是实例变量
        i++;
        j++;
        s++;
    }

    public void test(int j){//形参 局部变量
        //就近原则
        j++;
        i++;
        s++;
    }

    public static void main(String[] args) {//形参 局部变量
        //局部变量
        GlobalAndLocalTest global1 = new GlobalAndLocalTest();
        GlobalAndLocalTest global2 = new GlobalAndLocalTest();
        global1.test(10);
        global1.test(20);
        global2.test(30);

//        System.out.println(String.valueOf(global1.i) + "," + String.valueOf(global1.j) + "," + String.valueOf(global1.s));
        System.out.println(global1.i + "," + global1.j + "," + GlobalAndLocalTest.s);
        //2,1,5
        System.out.println(global2.i + "," + global2.j + "," + GlobalAndLocalTest.s);
        //1,1,5
    }
}
