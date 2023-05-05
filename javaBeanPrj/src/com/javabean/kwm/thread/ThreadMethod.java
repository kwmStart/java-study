package com.javabean.kwm.thread;

/**
 * @ClassName ThreadMethod
 * @Description 测试Thread中的常用方法
 * 1、start()：启动当前线程；调用当前线程的run()方法
 * 2、run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明到此方法中
 * 3、currentThread()：静态方法，返回执行当前代码的线程。
 * 4、getName(): 获取当前线程名称
 * 5、setName(): 设置当前线程名称
 * 6、yield()：释放当前线程CPU的执行权。
 *
 * @Author kwm
 * @Date 2023/5/5 20:01
 */
class MethodThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 ==  0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }

            if (i % 20 == 0 ){
                yield();
            }
        }
    }

    // 空参构造器
    public MethodThread() {

    }

    // 含参构造器
    public MethodThread(String name) {
        super(name);
    }
}

public class ThreadMethod {

    public static void main(String[] args) {

        MethodThread thread1 = new MethodThread();
        thread1.setName("线程一");
        thread1.start();

        // 调用含参构造器
       /* MethodThread thread2 = new MethodThread("Thread：1");
        thread2.start();*/

        // 测试当前线程 线程名称
       /* MethodThread thread3 = new MethodThread();
        thread3.start();*/

        // 给主线程设置名称
        Thread.currentThread().setName("主线程");

        for (int i = 0; i < 100; i++) {
            if (i % 2 ==  0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }

            if (i == 20 ) {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // 测试当前线程 线程名称
        /*MethodThread thread4 = new MethodThread("ceshi");
        thread4.start();*/

    }
}
