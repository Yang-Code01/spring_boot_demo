package com.qingmin.demo01.product.demo2;

/**
 * @author code-yang
 * @date 2021/8/3 13:23
 * @Description
 * @Return
 * @Throws
 */
public class ConcreteCreator extends Creator{
    @Override
    public <T extends Product> T createProduct(Class<T> c) {

        Product product = null;
        try {
            product = (T) Class.forName(c.getName()).newInstance();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
