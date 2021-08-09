package com.qingmin.demo01.tmplate;

/**
 * @author code-yang
 * @date 2021/8/9 10:57
 * @Description
 * @Return
 * @Throws
 */
public class Client {
    public static void main(String[] args) {
        // 佛祖保佑，无 bug 运行
        AbstractClass class1 = new ConcreteClass1();
        AbstractClass class2 = new ConcreteClass2();
        class1.templateMethod();
        class2.templateMethod();
    }
}
