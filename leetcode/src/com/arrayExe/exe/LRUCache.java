package com.arrayExe.exe;

import java.util.LinkedHashMap;

/**
 * @author code-yang
 * @date 2021/9/18 16:40
 * @Description
 * @Return
 * @Throws
 */
// 最近最少使用
    // 复杂度为 O1  hash + 链表  hashMAP 加 双向链表

public class LRUCache<K,V> extends LinkedHashMap<K,V> {


    private int capacity;
    public LRUCache(int capacity){
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    @Override
    public V get(Object key) {
        return super.get(key);
    }

    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,"a");
        lruCache.put(2,"b");
        lruCache.put(3,"c");
        lruCache.put(4,"d");

        System.out.println(lruCache.keySet());

    }



}
