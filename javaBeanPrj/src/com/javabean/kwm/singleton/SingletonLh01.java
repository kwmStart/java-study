package com.javabean.kwm.singleton;

/**
 * @ClassName SingletonEh01
 * @Description 懒汉式1
 *
 * @Author kwm
 * @Date 2020/5/26 15:56
 */
public class SingletonLh01 {
    //1、构造方法私有化
    private SingletonLh01(){
    }
    //2、自行创建并用静态常量保存
    private static SingletonLh01 INSTANCE;
    //3、获取get方法
    public static SingletonLh01 getInstance(){

        if (null==INSTANCE){
            //当不加同步代码块时 为线程不安全
            synchronized (SingletonLh01.class){
                if (null == INSTANCE){
                    INSTANCE = new SingletonLh01();
                }
            }
        }
        return INSTANCE;
    }
}

//2、通过静态内部类来初始化实例对象
//  在内部类被加载和初始化时，才创建instance实例化对象
//  静态内部类不会自动随内部类的加载和初始化而而初始化，但内部类时单独的初始化和加载的
class SingletonLh02 {
    //私有化构造器方法
    private SingletonLh02(){

    }
    //构造内部类 初始化实例对象
    private static class Inner {
        private static final SingletonLh02 INSTANCE = new SingletonLh02();
    }
    public static SingletonLh02 getInstance() {
        return Inner.INSTANCE;
    }
}


