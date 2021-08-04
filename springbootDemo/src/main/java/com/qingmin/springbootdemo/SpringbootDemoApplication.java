package com.qingmin.springbootdemo;

import ch.qos.logback.core.db.DBHelper;
import com.qingmin.springbootdemo.bean.Pet;
import com.qingmin.springbootdemo.bean.User;
import com.qingmin.springbootdemo.config.MainConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 可惜没有如果
 */


@SpringBootApplication // same as @SpringBootConfiguration @EnableAutoConfiguration @ComponentScan
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootDemoApplication.class, args);

//        System.out.println("--------------");
//
//        // com.qingmin.springbootdemo.config.MainConfig$$EnhancerBySpringCGLIB$$aa8c38b0@68e62ca4
//        // 这是一个代理的类
//        MainConfig mainConfig = run.getBean(MainConfig.class);
//        System.out.println(mainConfig);
//
//        /*
//        我们的这个User 是从配置代理类中获取，而不是直接从容器中拿
//         */
//        // 如果@Configuration(proxyBeanMethods = true)代理对象调用方法，Springboot总会检查这个组件是否在容器中
//        // 保持组件单实例
//        User qingmin = mainConfig.user();
//        User qingmin01 = mainConfig.user();
//
//        System.out.println(qingmin01 == qingmin);
//
//
//        User user01 = run.getBean("qingmin", User.class);
//        Pet pet1 = user01.getPet();
//
//        Pet pet = run.getBean("tomcat", Pet.class);
//
//
//        System.out.println("容器中的宠物："+ (pet1 == pet));
//
//
//        System.out.println("---------------");
//
//        String[] beanNamesForType = run.getBeanNamesForType(DBHelper.class);
//
//        for (String name : beanNamesForType) {
//            System.out.println(name);
//        }

        boolean qingmin = run.containsBean("qingmin");
        System.out.println("容器红是否右：User  "+ qingmin);

        boolean tomcat = run.containsBean("tomcat");
        System.out.println("容器红是否右：Pet  "+  tomcat);


        boolean cat = run.containsBean("cat");
        System.out.println("容器红是否右：cat  "+  cat);

        boolean haha = run.containsBean("haha");
        System.out.println("容器红是否右：haha  "+  haha);

        System.out.println("____________________");




    }

}
