package com.qingmin.demo01.tmplate;

/**
 * @author code-yang
 * @date 2021/8/9 10:56
 * @Description
 * @Return
 * @Throws
 */
public class ConcreteClass1 extends AbstractClass{
    @Override
    protected void doSomething() {
        // 业务逻辑
        System.out.println("业务逻辑1");
    }

    @Override
    protected void doAnything() {
        // 业务逻辑
        System.out.println("业务逻辑2");
    }
}
