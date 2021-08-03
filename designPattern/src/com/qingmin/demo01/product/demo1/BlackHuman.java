package com.qingmin.demo01.product.demo1;

/**
 * @author code-yang
 * @date 2021/8/3 10:42
 * @Description
 * @Return
 * @Throws
 */
public class BlackHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("黑人");
    }

    @Override
    public void talk() {
        System.out.println("黑人的话");
    }
}
