package com.javabean.kwm.singleton;

import java.util.concurrent.*;

/**
 * @ClassName SingletonTest
 * @Description 测试单例模式
 * @Author kwm
 * @Date 2020/5/26 15:04
 */
public class SingletonTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1、
        SingletonEh01 singletonEh01 = SingletonEh01.SINGLETON_LH_01;
        System.out.println(singletonEh01);
        //2、
        SingletonEh02 singletonEh02 = SingletonEh02.INSTANCE;
        System.out.println(singletonEh02);
        //3、
        SingletonEh04 singletonEh04 = SingletonEh04.getInstance();
        System.out.println(singletonEh04);

        //4、创建多线程调用
        Callable<SingletonLh01> callable = new Callable<SingletonLh01>() {
            @Override
            public SingletonLh01 call() throws Exception {
                return SingletonLh01.getInstance();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<SingletonLh01> eh01Future = es.submit(callable);
        Future<SingletonLh01> eh02Future = es.submit(callable);

        SingletonLh01 eh01 = eh01Future.get();
        SingletonLh01 eh02 = eh02Future.get();

        System.out.println(eh01 == eh02);
        System.out.println(eh01);
        System.out.println(eh02);

        //5、通过调用内部类创建实例
        SingletonLh02 singletonLh02 = SingletonLh02.getInstance();
        System.out.println(singletonLh02);
    }


}
