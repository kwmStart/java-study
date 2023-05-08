package com.javabean.kwm.thread;

/**
 * @ClassName ThreadSaleTicketRunnableTest
 * @Description 通过实现Runnable接口的方式来实现  三个窗口买票 票张数为100张
 * TODO 存在线程安全问题 待解决
 * @Author kwm
 * @Date 2023/5/8 21:48
 */
class SaleTicketRunnable implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为： " + ticket);
                ticket --;
            }else {
                break;
            }
        }
    }
}

public class ThreadSaleTicketRunnableTest {

    public static void main(String[] args) {
        SaleTicketRunnable saleTicketRunnable = new SaleTicketRunnable();

        Thread t1 = new Thread(saleTicketRunnable);
        Thread t2 = new Thread(saleTicketRunnable);
        Thread t3 = new Thread(saleTicketRunnable);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
