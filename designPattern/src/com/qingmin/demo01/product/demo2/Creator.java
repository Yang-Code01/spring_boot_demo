package com.qingmin.demo01.product.demo2;

/**
 * @author code-yang
 * @date 2021/8/3 11:18
 * @Description
 * @Return
 * @Throws
 */
public abstract class Creator {

    public abstract <T extends Product> T createProduct(Class<T> c);
}
