package com.qingmin.demo01.product.demo1;

/**
 * @author code-yang
 * @date 2021/8/3 10:41
 * @Description
 * @Return
 * @Throws
 */
public class YellowHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("黄种人");
    }

    @Override
    public void talk() {
        System.out.println("说汉语");
    }
}
