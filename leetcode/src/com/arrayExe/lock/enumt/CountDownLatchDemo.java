package com.arrayExe.lock.enumt;

import java.util.concurrent.CountDownLatch;

/**
 * @author code-yang
 * @date 2021/9/8 15:58
 * @Description 通过秦灭六国的例子模拟前提条件都完成才执行其他线程
 * @Return
 * @Throws
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() +"灭国");
                // 计数器每次执行一次就减一
                countDownLatch.countDown();
            },CountryEnum.forEach_CountryEnum(i).getGetRetValue()).start();
        }
        // 只有countDownLatch coutDown 完成后才通知
        countDownLatch.await();
        System.out.println("秦朝统一");

    }
}
