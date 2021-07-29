package com.qingmin.springbootdemo.config;

import ch.qos.logback.core.db.DBHelper;
import com.qingmin.springbootdemo.bean.Car;
import com.qingmin.springbootdemo.bean.Pet;
import com.qingmin.springbootdemo.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

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
 *
 *  @Import({User.class, DBHelper.class}) id 默认是全类名，导入第三方的组件到容器中
 *
 * @Conditional 可以标注在方法，类上
 *
 */

@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)
@ConditionalOnMissingBean(name = "tomcat")
@ImportResource("classpath:/beans.xml")
//@EnableConfigurationProperties(Car.class)
//1、开启Car配置绑定功能
//2、把这个Car这个组件自动注册到容器中
public class MainConfig {



//    @Bean
//    public Car car(){
//        return new Car();
//    }

    /*
    默认是单实例
     */
    // @ConditionalOnBean(name = "tomcat")
    @Bean("qingmin")
    public User user(){
        User user = new User("杨庆敏",22,pet());
        return user ;
    }

    //@Bean("tomcat")
    public Pet pet(){
        return new Pet("tomcat",11);
    }

}
