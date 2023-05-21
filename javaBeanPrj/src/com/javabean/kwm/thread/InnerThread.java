package com.javabean.kwm.thread;

/**
 * @author kwm
 * @Title: InnerThread
 * @ProjectName java-study
 * @Description: 练习 测试内部类
 * @date 2023/5/12 15:49
 */
public class InnerThread {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + "的优先级为： " + getPriority());
            }
        };
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();

        System.out.println(Thread.currentThread().getName() + "的优先级为： "
                + Thread.currentThread().getPriority());
    }

}
