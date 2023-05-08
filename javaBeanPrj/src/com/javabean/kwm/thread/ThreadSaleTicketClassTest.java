package com.javabean.kwm.thread;

/**
 * @ClassName ThreadSaleTicketClassTest
 * @Description 通过继承Thread类的方式来实现  三个窗口买票 票张数为100张
 * TODO 存在线程安全问题 待解决
 * @Author kwm
 * @Date 2023/5/8 21:48
 */

class SaleTicketClass extends Thread {

    // 需要定义票数为静态变量
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + ":卖票，票号为： " + ticket);
                ticket --;
            }else {
                break;
            }
        }
    }
}

public class ThreadSaleTicketClassTest {

    public static void main(String[] args) {
        SaleTicketClass t1 = new SaleTicketClass();
        SaleTicketClass t2 = new SaleTicketClass();
        SaleTicketClass t3 = new SaleTicketClass();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
