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
        SingletonLh01 singletonLh01 = SingletonLh01.SINGLETON_LH_01;
        System.out.println(singletonLh01);
        //2、
        SingletonLh02 singletonLh02 = SingletonLh02.INSTANCE;
        System.out.println(singletonLh02);
        //3、
        SingletonLh04 singletonLh04 = SingletonLh04.getInstance();
        System.out.println(singletonLh04);

        //4、创建多线程调用
        Callable<SingletonEh01> callable = new Callable<SingletonEh01>() {
            @Override
            public SingletonEh01 call() throws Exception {
                return SingletonEh01.getInstance();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<SingletonEh01> eh01Future = es.submit(callable);
        Future<SingletonEh01> eh02Future = es.submit(callable);

        SingletonEh01 eh01 = eh01Future.get();
        SingletonEh01 eh02 = eh02Future.get();

        System.out.println(eh01 == eh02);
        System.out.println(eh01);
        System.out.println(eh02);
    }


}
