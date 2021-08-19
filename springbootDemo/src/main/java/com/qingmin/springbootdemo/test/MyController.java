package com.qingmin.springbootdemo.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author code-yang
 * @date 2021/8/9 16:23
 * @Description
 * @Return
 * @Throws
 */
@RestController
public class MyController {

    @GetMapping("/hef")
    public String hello(){
        return "你好";
    }
}
