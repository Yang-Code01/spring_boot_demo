package com.qingmin.demo01.product.demo4;

/**
 * @author code-yang
 * @date 2021/8/9 10:01
 * @Description 抽象产品类
 * @Return
 * @Throws
 */

public abstract class AbstractProductA {
    // 每个产品共有的功能
    public void shareMethod(){

    }
    // 每个产品相同的方法，不同实现
    public abstract void doSomething();
}
