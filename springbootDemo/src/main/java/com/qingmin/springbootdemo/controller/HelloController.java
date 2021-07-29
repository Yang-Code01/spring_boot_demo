package com.qingmin.springbootdemo.controller;

import com.qingmin.springbootdemo.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author code-yang
 * @date 2021/7/28 22:18
 * @Description
 * @Return
 * @Throws
 */
@RestController
public class HelloController {

    @Autowired
    private Car car;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }




    @RequestMapping("/hello")
    public String handle01(){
        return "hello SpringBoot 2.5.0" + "杨庆敏";
    }
}
