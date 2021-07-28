package com.qingmin.springbootdemo.controller;

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

    @RequestMapping("/hello")
    public String handle01(){
        return "hello SpringBoot 2.5.0" + "杨庆敏";
    }
}
