package com.arrayExe.lock.enumt;

import java.util.concurrent.Semaphore;

/**
 * @author code-yang
 * @date 2021/9/8 17:54
 * @Description
 * @Return
 * @Throws
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        /**
         * 多个线程抢多个资源
         */
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() +"线程：抢车位,stop");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() +"线程：离开车位,start");
                }
            },String.valueOf(i)).start();
        }
    }
}
