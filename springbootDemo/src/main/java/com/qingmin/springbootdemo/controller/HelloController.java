package com.qingmin.springbootdemo.controller;

import com.qingmin.springbootdemo.bean.Car;
import com.qingmin.springbootdemo.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author code-yang
 * @date 2021/7/28 22:18
 * @Description
 * @Return
 * @Throws
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private Car car;

    @Autowired
    private Person person;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    @RequestMapping("/person")
    public Person person(){
        System.out.println(person);
        return person;
    }



    @RequestMapping("/hello001")
    public String handle01(@RequestParam(value = "name",required = false) String name){
        log.info("请求进来... ");
        return "hello SpringBoot 2.5.0" + name;
    }
}
