package com.javabean.kwm.singleton;

/**
 * @ClassName SingletonEh01
 * @Description 饿汉式
 *
 * @Author kwm
 * @Date 2020/5/26 15:56
 */
public class SingletonEh01 {
    //1、构造方法私有化
    private SingletonEh01(){
    }
    //2、自行创建并用静态常量保存
    private static SingletonEh01 INSTANCE;
    //3、获取get方法
    public static  SingletonEh01 getInstance(){

        if (null==INSTANCE){
            //当不加同步代码块时 为线程不安全
            synchronized (SingletonEh01.class){
                if (null == INSTANCE){
                    INSTANCE = new SingletonEh01();
                }
            }
        }
        return INSTANCE;
    }
}

//2、通过静态内部类来初始化实例对象
//  在内部类被加载和初始化时，才创建instance实例化对象
//  静态内部类不会自动随内部类的加载和初始化而而初始化，但内部类时单独的初始化和加载的
class SingletonEh02 {
    //私有化构造器方法
    private SingletonEh02(){

    }
    //构造内部类 初始化实例对象
    private static class Inner {
        private static final SingletonEh02 INSTANCE = new SingletonEh02();
    }
    public static SingletonEh02 getInstance() {
        return Inner.INSTANCE;
    }
}


