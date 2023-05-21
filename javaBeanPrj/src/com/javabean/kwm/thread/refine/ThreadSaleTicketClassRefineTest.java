package com.javabean.kwm.thread.refine;

/**
 * @ClassName ThreadSaleTicketClassTest
 * 使用同步代码块解决 继承Thread的方式的 线程安全问题。
 *
 * @Description 通过继承Thread类的方式来实现  三个窗口买票 票张数为100张 --完善 Refine
 *
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，可以考虑使用当前类来充当同步监视器。
 *
 * @Author kwm
 * @Date 2023/5/8 21:48
 */

class SaleTicketClassRefine extends Thread {

    // 需要定义票数为静态变量
    private static int ticket = 100;

    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // 正确的方式
            synchronized (obj) {
//                synchronized (SaleTicketClassRefine.class) {
//                正确方式二 Class clazz = SaleTicketClassRefine.class  类值加载一次

                //错误的方式：this代表的是t1/t2/t3三个对象
                //synchronized (obj) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (ticket > 0) {
                    System.out.println(getName() + ":卖票，票号为： " + ticket);
                    ticket --;
                }else {
                    break;
                }
            }

        }
    }
}

public class ThreadSaleTicketClassRefineTest {

    public static void main(String[] args) {
        SaleTicketClassRefine t1 = new SaleTicketClassRefine();
        SaleTicketClassRefine t2 = new SaleTicketClassRefine();
        SaleTicketClassRefine t3 = new SaleTicketClassRefine();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
