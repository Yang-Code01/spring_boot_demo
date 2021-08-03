package com.qingmin.demo01.product.demo3;

import java.lang.reflect.Constructor;

/**
 * @author code-yang
 * @date 2021/8/3 14:10
 * @Description
 * @Return
 * @Throws
 */
public class SingletonFactory {
    private static Singleton singleton;
    static {
        try {
            Class cl = Class.forName(Singleton.class.getName());
            // 获取无参构造器
            Constructor constructor = cl.getDeclaredConstructor();
            // 设置构造器可访问
            constructor.setAccessible(true);
            // 产生一个实例对象
            singleton = (Singleton) constructor.newInstance();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 提供获取单例方法
    public static Singleton getSingleton(){
        return singleton;
    }
}
