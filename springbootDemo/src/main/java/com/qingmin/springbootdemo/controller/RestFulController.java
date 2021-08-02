package com.qingmin.springbootdemo.controller;

import com.qingmin.springbootdemo.bean.Human;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * @author code-yang
 * @date 2021/7/31 21:44
 * @Description
 * @Return
 * @Throws
 */

@RestController
public class RestFulController {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "get-Method";
    }

    //@RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String addUser(){
        return "post-Method";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "delete-Method";
    }
    //@RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String updateUser(){
        return "put-Method";
    }

    @PatchMapping("/user")
    public String patchUser(){
        return "patch_Method";
    }



    @PostMapping("/saveHuman")
    public Human saveHuman(Human human){

        return human;
    }


}
