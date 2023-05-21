package com.javabean.kwm.thread.refine;

/**
 * @ClassName ThreadSaleTicketRunnableTest
 * @Description 通过实现Runnable接口的方式来实现  三个窗口买票 票张数为100张
 * 1.问题：卖票过程中，出现了重票和错票问题 --> 出现了线程安全问题
 * 2、问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作了车票。
 * 3、如何解决：当一个线程a在操作ticket时，其他的线程不能参与进来，直到线程a操作完ticket时，其他线程
 *             才可以开始操作ticket，这种情况即使线程a出现了阻塞，也不能被改变。
 * 4、在Java中，我们通过同步机制，来解决线程安全问题。
 *    利用同步代码块 解决线程不安全问题
 *    方式一：同步代码块
 *          synchronized（同步监视器） {
 *              // 需要被同步的代码
 *
 *          }
 *     说明： 1、操作共享数据的代码，即为需要同步的代码。
 *           2、共享数据：多个线程共同操作的变量。例如：ticket即为共享数据。
 *           3、同步监视器：俗称为“锁”。 任何一个类的对象都可以充当锁.
 *                要求：所有线程必须共用一把锁。
 *
 *    方式二：同步方法
 * 5、同步的方式：解决了线程安全问题。---好处。
 *     操作同步代码块时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程。效率低。  ---局限性
 *
 * @Author kwm
 * @Date 2023/5/21 21:48
 */
class SaleTicketRunnable implements Runnable {

    private int ticket = 100;

    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
//            synchronized (obj) {  // 方式一
            synchronized (this) {  // 方式二 此时的this 就是SaleTicketRunnable 创建的对象
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为： " + ticket);
                    ticket --;
                }else {
                    break;
                }
            }
        }
    }
}

public class ThreadSaleTicketRunnableRefineTest {

    public static void main(String[] args) {
        SaleTicketRunnable saleTicketRunnable = new SaleTicketRunnable();

        Thread t1 = new Thread(saleTicketRunnable);
        Thread t2 = new Thread(saleTicketRunnable);
        Thread t3 = new Thread(saleTicketRunnable);

        // 设置线程名称
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
