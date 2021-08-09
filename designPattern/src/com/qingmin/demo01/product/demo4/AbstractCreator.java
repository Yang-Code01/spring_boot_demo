package com.qingmin.demo01.product.demo4;

/**
 * @author code-yang
 * @date 2021/8/9 10:05
 * @Description 抽象工厂类
 * @Return
 * @Throws
 */
public abstract class AbstractCreator {
    // 创建A产品家族
    public abstract AbstractProductA createProductA();

    // 创建B产品家族
    public abstract AbstractProductB creatorProductB();


}
