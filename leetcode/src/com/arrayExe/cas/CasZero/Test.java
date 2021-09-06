package com.arrayExe.cas.CasZero;

/**
 * @author code-yang
 * @date 2021/9/6 15:11
 * @Description
 * @Return
 * @Throws
 */
public class Test {

    private static volatile int count = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {

                for (int j = 0; j < 100; j++) {
                    count++;
                }
            },String.valueOf(i)).start();

        }

        System.out.println("count = " + count);


    }
}
