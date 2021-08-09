package com.qingmin.demo01.product.demo4;

/**
 * @author code-yang
 * @date 2021/8/9 10:07
 * @Description 产品等级1的实现类
 * @Return
 * @Throws
 */
public class Creator1 extends AbstractCreator{
    // 只生产等级为1 的的A产品
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB creatorProductB() {
        return new ProductB1();
    }


}
