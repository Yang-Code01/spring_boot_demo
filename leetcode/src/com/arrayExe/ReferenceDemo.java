package com.arrayExe;

/**
 * @author code-yang
 * @date 2021/9/16 17:05
 * @Description
 * @Return
 * @Throws
 */
public class ReferenceDemo {

    // 强引用
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = o1;
        o1 = null;
        System.gc();
        System.out.println("o2 = " + o2);
    }
}
