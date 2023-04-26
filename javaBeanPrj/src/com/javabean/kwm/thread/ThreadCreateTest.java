package com.javabean.kwm.thread;

/**
 * 多线程的创建：方式一：继承于Thread类
 * 1、创建一个继承于Thread的子类
 * 2、重写Thread类的run()方法--> 将此线程执行的操作声明在run()方法中
 * 3、创建Thread类的子类的对象
 * 4、通过此对象调用start()方法
 *
 * 事例：遍历一百以内的所有偶数
 */
//1、创建一个继承于Thread的子类
class MyThread extends Thread{
    //2、重写Thread类的run()方法--> 将此线程执行的操作声明在run()方法中
    @Override
    public void run() {
        for (int i = 0;i <= 100;i++){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}


public class ThreadCreateTest {

    public static void main(String[] args) {

//     3、创建Thread类的子类的对象
        MyThread thread = new MyThread();
//        4、通过此对象调用start()方法 ①、启动当前线程。②、调用当前线程的run()
        thread.start();

        //thread.start(); 不可以启动两次当做两个线程 否则会报错IllegalThreadStateException
        // 线程状态发生变化
        // 需要重新创建线程对象
        MyThread thread1 = new MyThread();
        thread1.start();

        //下列数据在main线程执行
        for (int i = 0;i <= 100;i++){
            System.out.println("Thread.main" + "=======" + i);
        }

        //创建Thread类的匿名子类的方式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0;i <= 100;i++){
                    if (i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + ":" +i);
                    }
                }
            }
        }.start();

    }
}
