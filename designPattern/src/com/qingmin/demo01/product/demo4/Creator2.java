package com.qingmin.demo01.product.demo4;

/**
 * @author code-yang
 * @date 2021/8/9 10:10
 * @Description 产品等级2 的实现类
 * @Return
 * @Throws
 */
public class Creator2 extends AbstractCreator{
    // 只生产产品等级2的A产品
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB creatorProductB() {
        return new ProductB2();
    }


}
