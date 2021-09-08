package com.arrayExe.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author code-yang
 * @date 2021/9/8 15:19
 * @Description 读写分离实验
 * @Return
 * @Throws
 */

class MyCache{
    // 保证写完之后，立即更新到主存中，使用volatile 保证可见性
    private volatile Map<String, Object> map = new HashMap<>();
    // 读写锁
    /**
     * 写的时候保证一个线程从头执行到尾，读的时候允许多个线程并发读
     */
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();


    public void put(String key,Object value){
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() +":正在写入："+key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() +"：写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get(String key){
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() +":正在读取："+key );
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() +":读取完成；");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }


}

/**
 * @author AVTNTW672
 */
public class ReadWriteLock {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int tempKey = i;
            new Thread(() -> {
                myCache.put(tempKey+"",tempKey+"");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tempKey = i;
            new Thread(() -> {
                myCache.get(tempKey+"");
            },String.valueOf(i)).start();
        }
    }


}
