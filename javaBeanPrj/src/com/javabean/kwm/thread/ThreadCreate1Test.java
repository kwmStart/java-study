package com.javabean.kwm.thread;

/**
 * 多线程的创建：方式二：实现Runnable接口
 * 1、创建一个实现Runnable接口的类
 * 2、实现类去实现Runnable接口的抽象方法：run()
 * 3、创建实现类的对象
 * 4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5、通过Thread类的对象调用start()
 *
 * 比较创建线程的两种方式
 * 开发中，优先使用实现Runnable接口方式
 * 原因：1、实现的方式没有类的单继承性的局限性
 *      2、 实现的方式更适合来处理多个线程有共享数据的情况。
 * 联系：public class Thread implements Runnable
 * 相同点： 两种方式都需要重写run()方法，将线程要执行的逻辑声明到run()中。
 *
 * @ClassName ThreadCreate1Test
 * @Description 多线程创建方式二练习
 * @Author kwm
 * @Date 2023/5/8 21:58
 */
// 1、创建一个实现Runnable接口的类
class MThread implements Runnable {
//    2、实现类去实现Runnable接口的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0;i <= 100;i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" +i);
            }
        }
    }
}

public class ThreadCreate1Test {

    public static void main(String[] args) {
        // 3、创建实现类的对象
        MThread mThread = new MThread();

        // 4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mThread);
        t1.setName("线程一");
        // 5、通过Thread类的对象调用start() ①启动线程 ②调用当前线程的run()
        t1.start();

        // 重新再启动一个线程，遍历100以内的整数
        Thread t2 = new Thread(mThread);
        t2.setName("线程二");
        t2.start();
    }

}


