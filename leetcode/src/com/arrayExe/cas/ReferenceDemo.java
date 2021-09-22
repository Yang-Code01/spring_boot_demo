package com.arrayExe.cas;

/**
 * @author code-yang
 * @date 2021/9/18 16:02
 * @Description
 * @Return
 * @Throws
 */

import sun.misc.Unsafe;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 *
 * 软引用：只会在内存不足的时候回收
 */
public class ReferenceDemo {

    public static void softRef_memory_Enough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
       // System.gc();


        System.out.println(o1);
        System.out.println(softReference.get());
    }

    public static void softRef_memory_NotEnough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;

        try {
            byte[] bytes = new byte[1024 * 1024 * 1024 *30];

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }



    }

    public static void main(String[] args) {
        // ReferenceDemo.softRef_memory_Enough();
        // ReferenceDemo.softRef_memory_NotEnough();
    }
}

class WeakReferenceDemo{
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();


        System.out.println("-- ------");
        System.out.println(o1);
        System.out.println(weakReference.get());

    }
}