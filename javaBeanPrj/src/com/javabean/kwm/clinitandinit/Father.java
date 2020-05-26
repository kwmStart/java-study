package com.javabean.kwm.clinitandinit;

/**
 * @ClassName Father
 * @Description 父类加载和父类实例
 * @Author kwm
 * @Date 2020/5/26 21:23
 */
public class Father {
    //非静态实例变量
    private int i = test();
    //静态变量
    private static int j = method();

    //静态代码块
    static {
        System.out.print("(1)");
    }
    //构造器
    Father(){
        System.out.print("(2)");
    }
    //非静态代码块
    {
        System.out.print("(3)");
    }

    public int test(){
        System.out.print("(4)");
        return 1;
    }

    public static int method() {
        System.out.print("(5)");
        return 1;
    }
}
