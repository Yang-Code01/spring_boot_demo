package com.qingmin.demo01.product.demo1;

/**
 * @author code-yang
 * @date 2021/8/3 10:43
 * @Description
 * @Return
 * @Throws
 */
public class WhiteHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("白种人");
    }

    @Override
    public void talk() {
        System.out.println("说英语");
    }
}
