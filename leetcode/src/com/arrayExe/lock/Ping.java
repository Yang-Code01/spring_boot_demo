package com.arrayExe.lock;

/**
 * @author code-yang
 * @date 2021/9/18 11:09
 * @Description
 * @Return
 * @Throws
 */
public class Ping {

    static {
        System.out.println("pong");
    }

    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println("ping");
            }
        };
        t.run();
        System.out.println("pong");
    }
}
