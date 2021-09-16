package com.arrayExe;

/**
 * @author code-yang
 * @date 2021/9/16 16:34
 * @Description
 * @Return
 * @Throws
 */
/**
 * 可达性分析法，从 GC Roots 对象作为起始点，从这个结点出发，开始向下搜索，某个对象可以被从gcRoots 被指向，则不可回，
 * 判定存货，反正死亡
 */

/**
 * java 中可以作为 GC Roots 的对象的有：
 * 1、虚拟机栈（栈帧中的本地变量表）中的引用对象；
 * 2、方法区中的类静态属性引用的对象
 * 3、方法区中的常量引用的对象
 * 4、本地方法栈中JNI（即一般说的Native 方法）
 */
public class GCRootDemo {
    private byte[] byteArray = new byte[100 *1024 * 1024];
    private static GCRootDemo t2;
    private static final GCRootDemo t3 = new GCRootDemo();

    public static void m1(){
        GCRootDemo t1 = new GCRootDemo();
        System.gc();
        System.out.println("第一次GC完成");
    }

    public static void main(String[] args) {
        m1();
    }
}
