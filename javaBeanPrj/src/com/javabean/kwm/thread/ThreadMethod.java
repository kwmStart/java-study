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
 * 7、join(): 在线程a中调用线程b的join()，此时线程a就进入到阻塞状态，直到线程b完全执行完成以后，线程a才结束阻塞状态。
 * 8、stop(): 已过时。 当执行该方法时，强制结束当前线程。
 * 9、sleep(long milliTime) 单位毫秒； 让当前线程“睡眠”指定的milliTime毫秒，在指定的milliTime毫秒时间内，当前线程是阻塞状态。
 * 10、isAlive()： 判断当前线程是否存活
 *
 *
 * 线程优先级
 * 1、
 *   MIN_PRIORITY=1;
 *   NORM_PRIORITY=5;  -- 默认的优先级
 *   MAX_PRIORITY=10;
 * 2、如何获取和设置当前线程的优先级
 *   getPriority() 获取当前线程的优先级
 *   setPriority(int p) 设置当前线程的优先级
 *
 *   说明： 高优先级的线程要抢占低优先级的线程CPU的执行权。但只是从概率上抢占（即获取执行权的优先级比较高），即高优先级的线程高概率的
 *   情况下会被CPU执行，但并不意味着只能当高优先级的线程执行完成以后，低优先级的线程才可以被执行。
 *
 * @Author kwm
 * @Date 2023/5/5 20:01
 */
class MethodThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            // 设置睡眠时间
            /* todo 测试线程优先级 注释掉
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/

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

/**
 * 测试线程方法
 * 线程的调度
 * 调度策略： 1、时间片式调度  2、抢占式调度： 高优先级的线程抢占CPU
 */
public class ThreadMethod {

    public static void main(String[] args) {

        MethodThread thread1 = new MethodThread();
        thread1.setName("线程一");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();

        // 调用含参构造器
       /* MethodThread thread2 = new MethodThread("Thread：1");
        thread2.start();*/

        // 测试当前线程 线程名称
       /* MethodThread thread3 = new MethodThread();
        thread3.start();*/

        // 给主线程设置名称
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 ==  0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }

            /* todo 测试线程优先级 注释掉
            if (i == 20 ) {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }*/
        }

        // 测试当前线程 线程名称
        /*MethodThread thread4 = new MethodThread("ceshi");
        thread4.start();*/

    }
}
