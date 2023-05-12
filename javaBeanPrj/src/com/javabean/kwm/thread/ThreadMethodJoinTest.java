package com.javabean.kwm.thread;

/**
 * @author kwm
 * @Title: ThreadMethodJoinTest
 * @ProjectName java-study
 * @Description: 测试Thread类的join方法时效性以及释放CPU执行权后的线程执行顺序
 * @date 2023/5/12 9:42
 */
public class ThreadMethodJoinTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadMethodJoin t1Target = new ThreadMethodJoin();
        Thread t1 = new Thread(t1Target,"methodJoin");
        // methodJoin 线程启动
        t1.start();

//    方法一： 使用主线程进行测试
      Thread.currentThread().setName("主线程");
        // sleep会导致线程阻塞
//        Thread.sleep(10000);
        for (int i = 0; i < 100; i++) {

            if (i % 2 !=  0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }

            if (i == 20) {
                System.out.println("====================");
                try {
                    // 也会造成线程阻塞
//                    t1.join();
                    t1.join(200);
                    System.out.println("22222222222222222222222222");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }

        /*new Thread("测试join前置Thread"){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {

                    if (i % 2 !=  0) {
                        System.out.println(getName() + " : " + i);
                    }

                    if (i == 20) {
                        System.out.println("====================");
                        try {
                            t1.join();
                            System.out.println("22222222222222222222222222");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }
        }.start();*/


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 !=  0) {
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        },"测试join后置Thread").start();
    }
}

/**
 * 测试Thread类join方法
 */
class ThreadMethodJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            // 设置睡眠时间
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (i % 2 ==  0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }

        }

    }
}
