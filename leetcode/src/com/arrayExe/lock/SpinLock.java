package com.arrayExe.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author code-yang
 * @date 2021/9/8 14:20
 * @Description 自旋锁（CAS原理）
 * @Return
 * @Throws
 */
public class SpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void onLock(){
        System.out.println(Thread.currentThread().getName() +": onLock");
        // 当前线程
        Thread thread = Thread.currentThread();
        // 当前线程是否为null（解锁），为null 就跳出，否则 一直循环比较（CAS）
        while (! atomicReference.compareAndSet(null,thread)){

        }
    }

    public void unLock(){
        System.out.println(Thread.currentThread().getName() +": unLock");
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);

    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        new Thread(() -> {
            // 上锁
            spinLock.onLock();
            // 暂停线程 保证 B 线程 进入自旋状态
            try { TimeUnit.SECONDS.sleep(5);}catch (Exception e) { e.printStackTrace();}
            // 解锁
            spinLock.unLock();
            // B 自旋完成
        },"AA").start();

        // 暂停线程,确保先执行A线程
        try { TimeUnit.SECONDS.sleep(3);}catch (Exception e) { e.printStackTrace();}


        new Thread(() -> {
           spinLock.onLock();
           spinLock.unLock();
        },"BB").start();
    }


}
