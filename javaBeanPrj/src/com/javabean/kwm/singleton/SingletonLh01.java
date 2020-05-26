package com.javabean.kwm.singleton;

import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName SingletonLh01
 * @Description 懒汉式1
 * @Author kwm
 * @Date 2020/5/26 14:55
 */
public class SingletonLh01 {
    //1、构造方法私有化
    private SingletonLh01() {
    }
    //2、自行创建并用静态常量保存
    //3、通过public将对象暴露，并用final表示不可修改
    public static final SingletonLh01 SINGLETON_LH_01 = new SingletonLh01();

}

/**
 * 枚举类型 表示该类型的对象有有限几个
 * 我们限定为一个，即可为单例模式
 */
enum SingletonLh02 {
    //枚举类型的构造器为私有的
    INSTANCE;
}

//通过get方法将对象暴露出去
class SingletonLh03 {
    //2、自行创建并用静态常量保存
    private static  SingletonLh03 SINGLETON_LH_03 = new SingletonLh03();

    //1、构造方法私有化
    private SingletonLh03() {
    }
    //3、通过public将对象暴露，并用final表示不可修改
    public static SingletonLh03 getInstance(){
        return SINGLETON_LH_03;
    }
}

//4、使用静态代码块创建  在创建对象时候，需要获取其他参数或数据
class SingletonLh04 {

    private static  SingletonLh04 INSTANCE ;
    private String name;
    static {
        Properties ps = new Properties();
        //利用类加载器处理
        try {
            ps.load(SingletonLh04.class.getClassLoader().getResourceAsStream("single.properties"));
            INSTANCE = new SingletonLh04(ps.getProperty("name"));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private SingletonLh04(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SingletonLh04{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //暴露实例化对象
    public static SingletonLh04 getInstance() {
        return INSTANCE;
    }

}
