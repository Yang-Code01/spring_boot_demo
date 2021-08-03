package com.qingmin.demo01.product.demo1;

/**
 * @author code-yang
 * @date 2021/8/3 10:43
 * @Description
 * @Return
 * @Throws
 */
// 抽象人类工厂
public abstract class AbstractHumanFactory {

    // 使用泛型来规定创建的类必须是Human的实现类
    public abstract <T extends Human> T createHuman(Class<T> c);
}
