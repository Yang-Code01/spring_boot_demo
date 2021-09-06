package com.arrayExe;



import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author code-yang
 * @date 2021/9/6 16:59
 * @Description
 * @Return
 * @Throws
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        //List<String> list = Arrays.asList("a","b","c");
        ////list.stream().forEach(System.out::println);
        //list.forEach(System.out::println);

        List<String> list = new ArrayList<>();
        List<String> list2 = Collections.synchronizedList(list); //Vector


        //
        List<String> list1 = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list2.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list2);
            },String.valueOf(i)).start();
        }
        // 暂停线程
        try { TimeUnit.SECONDS.sleep(3);}catch (Exception e) { e.printStackTrace();}
        System.out.println("--------------");
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list1.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list1);
            },String.valueOf(i)).start();
        }

    }
}

