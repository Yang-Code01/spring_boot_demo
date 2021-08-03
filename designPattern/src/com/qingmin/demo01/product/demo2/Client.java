package com.qingmin.demo01.product.demo2;

/**
 * @author code-yang
 * @date 2021/8/3 13:25
 * @Description
 * @Return
 * @Throws
 */
public class Client {
    public static void main(String[] args) {
        // 佛祖保佑，无 bug 运行
        Creator creator = new ConcreteCreator();
        Product product = creator.createProduct(ConcreteProduct1.class);
        product.method02();
    }
}
