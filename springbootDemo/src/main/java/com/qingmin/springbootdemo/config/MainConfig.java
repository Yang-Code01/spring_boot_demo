package com.qingmin.springbootdemo.config;

import com.qingmin.springbootdemo.bean.Pet;
import com.qingmin.springbootdemo.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author code-yang
 * @date 2021/7/28 22:26
 * @Description
 * @Return
 * @Throws
 */

/**
 * proxyBeanMethods 代理bean的方法
 *  : Full :proxyBeanMethods = true
 *  : Lite :proxyBeanMethods = false
 *  应对组件依赖问题
 */
@Configuration(proxyBeanMethods = true)
public class MainConfig {

    /*
    默认是单实例
     */
    @Bean("qingmin")
    public User user(){
        User user = new User("杨庆敏",22,pet());
        return user ;
    }

    @Bean("tomcat")
    public Pet pet(){
        return new Pet("tomcat",11);
    }

}
