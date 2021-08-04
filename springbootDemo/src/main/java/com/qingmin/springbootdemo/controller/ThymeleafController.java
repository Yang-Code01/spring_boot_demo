package com.qingmin.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author code-yang
 * @date 2021/8/4 11:01
 * @Description
 * @Return
 * @Throws
 */
@Controller
public class ThymeleafController {


    @GetMapping("/thymeleaf01")
    public String success(Model model){
        model.addAttribute("name","zs");
        model.addAttribute("link", "https://www.baidu.com");
        return "success";
    }
}
