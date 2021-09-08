package com.arrayExe.lock.enumt;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author code-yang
 * @date 2021/9/8 17:25
 * @Description
 * @Return
 * @Throws
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        // CountDownLatch 做减法，CyclicBarrier 做加法
        // public CyclicBarrier(int parties, Runnable barrierAction)
        /**
         * 类似于 CountDownLatch 的反操作， 但是，这里的构造器就直接可以 写 前提任务完成后的任务，在前提任务每次执行一次后，只需要
         * 执行await 方法就行
         * 而 CountDownLatch 却没有这个构造器，而是先调用CountDown 方法，然后在最终执行的任务中调用await方法
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> System.out.println("召唤神龙"));
        for (int i = 1; i <= 7 ; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() +"\t " +tempInt + "龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }


    }
}



