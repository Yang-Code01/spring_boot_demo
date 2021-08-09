package com.qingmin.demo01.tmplate.demo1;

/**
 * @author code-yang
 * @date 2021/8/9 11:11
 * @Description
 * @Return
 * @Throws
 */
public abstract class HummerModel {


    protected abstract void start();

    protected abstract void stop();

    protected abstract void alarm();

    // 钩子函数，默认为true
    protected  boolean isAlarm(){
        return true;
    }

    final public void run(){
        this.start();
        if (isAlarm()){
            this.alarm();
        }
        this.stop();
    }


}
