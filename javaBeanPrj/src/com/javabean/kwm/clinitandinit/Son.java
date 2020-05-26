package com.javabean.kwm.clinitandinit;

/**
 * @ClassName Son
 * @Description 子类加载和子类实例
 * @Author kwm
 * @Date 2020/5/26 21:23
 */
public class Son extends Father{
    //非静态实例变量
    private int i = test();
    //静态变量
    private static int j = method();

    //静态代码块
    static {
        System.out.print("(6)");
    }
    //构造器
    Son(){
        System.out.print("(7)");
    }
    //非静态代码块
    {
        System.out.print("(8)");
    }

    @Override
    public int test(){
        System.out.print("(9)");
        return 1;
    }

    public static int method() {
        System.out.print("(10)");
        return 1;
    }

    public static void main(String[] args) {
        System.out.println();
        Son son1 = new Son();
        System.out.println();
        Son son2 = new Son();

        //(5)(1)(10)(6)
        //(9)(3)(2)(9)(8)(7)
        //(9)(3)(2)(9)(8)(7)

        /*
        类的初始化
            一、一个类要创建实例必须先加载并初始化该类；main方法所在的类要先加载和初始化
            二、一个子类要初始化 需要先加载和初始化其父类
            三、一个类初始化就是执行的<clinit>方法（class init）：
                1、clinit()方法由静态类变量显示赋值代码和静态代码块组成。
                2、类变量显示赋值代码和静态代码块从上到下顺序执行。
                3、<clinit>方法只执行一次
             因此在执行main'方法时，先执行son子类的加载和初始化，由于son继承父类father类
             所以
             先执行father类的初始化
               j = method();  --->(5)
               静态代码块 System.out.print("(1)");  -->(1)
             其后执行son类的初始化
                j = method();  --->(10)
               静态代码块 System.out.print("(6)");  -->(6)
             因此第一行输出为：(5)(1)(10)(6)

         实例的初始化：实例对象的初始化就是执行<init>方法。
             一、<init>方法可能重载有多个，有几个构造器就有几个init()方法。
             二、<init>方法由非静态类变量显示赋值代码和非静态代码块、对应构造器代码组成。
             三、非静态类变量显示赋值代码和非静态代码块按照从上往下顺序执行、对应构造器代码最后执行。
             四、每次创建对象实例，调用对用的构造器、执行对应的init方法。
             五、<init>方法首行是super()或者super(实参列表)，及对应父类的init方法。
                 即子类的实例时，一定先执行super() 即父类的构造方法 即先实例父类初始化

          方法的重写Override
              一、那些方法不可以被重写： final方法 静态方法  private等子类中不可见方法。
              二、对象的多态性：
                  子类如果重写的父类的方法，通过子类对象调用的一定是子类重写过的代码。
                  非静态方法默认的调用对象是this
                  this对象在构造器或者说<init>方法中就是正在创建的对象

          因此son实例初始化时
          一、 super()即先执行父类实例化  test()被子类对象重写  （9） 非静态代码块 （3） 无参构造器 （2）
          二、子类的test()    （9）
          三、非静态代码块 （8）
          四、无参构造器 （7）
          因此第二行输出是 (9)(3)(2)(9)(8)(7)

          由于初始化了两次
          因此第三行输出是(9)(3)(2)(9)(8)(7)
         */
    }
}
