package com.arrayExe.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author code-yang
 * @date 2021/9/6 13:39
 * @Description
 * @Return
 * @Throws
 */
public class CasDemo {





    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 1024)+"\t corrent:" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 10)+"\t corrent:" + atomicInteger.get());

    }


}
