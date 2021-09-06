package com.arrayExe.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author code-yang
 * @date 2021/9/6 16:21
 * @Description
 * @Return
 * @Throws
 */
public class ABADemo {
    
    public static AtomicReference atomicReference = new AtomicReference(100);

    public static AtomicStampedReference stampedReference = new AtomicStampedReference(100,1);


    public static void main(String[] args) {
        System.out.println("---ABA问题----");
        new Thread(() -> {
            // 线程一先执行完成
            System.out.println("t1 f:"+atomicReference.compareAndSet(100, 101)+"当前值："+atomicReference.get());
            System.out.println("t1 s:"+atomicReference.compareAndSet(101, 100)+"当前值："+atomicReference.get());
        },"t1").start();
        
        new Thread(() -> {
            // 暂停线程
            try { TimeUnit.SECONDS.sleep(1);}catch (Exception e) { e.printStackTrace();}

            boolean b = atomicReference.compareAndSet(100, 300);
            System.out.println("t2:"+b+"\t"+"当前值："+atomicReference.get());


        },"t2").start();
        
        // 暂停线程
        try { TimeUnit.SECONDS.sleep(3);}catch (Exception e) { e.printStackTrace();}
        

        System.out.println("----ABA问题的解决----");


        new Thread(() -> {
            System.out.println("t3线程开始");
            // 戳
            int stamp = stampedReference.getStamp();
            // 戳 --1 --》2 --》3
            System.out.println("初始戳："+stamp);
            stampedReference.compareAndSet(100,101,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println("stampedReference.getStamp() = " + stampedReference.getStamp());
            stampedReference.compareAndSet(101,100,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println("stampedReference.getStamp() = " + stampedReference.getStamp());
            System.out.println("t3线程结束");
        },"t3").start();

        new Thread(() -> {
            System.out.println("t4线程开始");
            // 暂停线程
            try { TimeUnit.SECONDS.sleep(5);}catch (Exception e) { e.printStackTrace();}

            int stamp = stampedReference.getStamp();
            System.out.println("戳："+stamp);
            // 预期值一样，但戳不一样
            boolean result = stampedReference.compareAndSet(100,200,1,2);
            System.out.println("result = " + result);
            System.out.println("当前戳：" + stampedReference.getStamp());

            System.out.println("t4线程结束");
        },"t4").start();
    }
}
