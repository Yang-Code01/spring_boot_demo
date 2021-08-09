package com.qingmin.demo01.product.demo4;

/**
 * @author code-yang
 * @date 2021/8/9 10:15
 * @Description
 * @Return
 * @Throws
 */
public class Client {
    public static void main(String[] args) {
        // 佛祖保佑，无 bug 运行
        // 定义出两个工厂
        AbstractCreator creator1 = new Creator1();
        AbstractCreator creator2 = new Creator2();

        // 产生A1对象
        AbstractProductA a1 = creator1.createProductA();
        // 产生A2对象
        AbstractProductA a2 = creator2.createProductA();


    }
}
