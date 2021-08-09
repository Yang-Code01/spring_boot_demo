package com.qingmin.demo01.tmplate;

/**
 * @author code-yang
 * @date 2021/8/9 10:54
 * @Description
 * @Return
 * @Throws
 */
public  abstract class AbstractClass {

    protected abstract void doSomething();

    protected abstract void doAnything();

    public void templateMethod(){
        this.doAnything();
        this.doSomething();
    }
}
