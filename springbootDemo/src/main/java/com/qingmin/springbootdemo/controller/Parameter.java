package com.qingmin.springbootdemo.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author code-yang
 * @date 2021/8/1 21:38
 * @Description
 * @Return
 * @Throws
 */
@RestController
public class Parameter {


    // 请求参数的获取， @RequestParam()
    // @PathVariable 请求路径上变量
    // user/1/zs
    @GetMapping("/test/{id}/{username}") // 默认的map 会存放 这个请求路径上的参数
    public Map<String,Object> getUser(
            @PathVariable(value = "id",required = false) Integer id,
            @PathVariable(value = "username",required = false) String name,
            @PathVariable(required = false) Map<String,String> pv,
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader Map<String,String> header,
            @RequestParam(value = "age",required = false) Integer age,
            @RequestParam(value = "inters",required = false) List<String> inters,
            @RequestParam(required = false) Map<String,String> params,
            @CookieValue("Idea-de297d9c") String Idea,
            @CookieValue("Idea-de297d9c") Cookie cookies
           ){
        Map<String,Object> map = new HashMap<>();
//        map.put("id",id);
//        map.put("username",name);
//        map.put("pv",pv);
//        map.put("userAgent",userAgent);
//        map.put("headers",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("allRequestParams",params);
        map.put("cookie1",Idea);

        System.out.println(cookies.getName());

        return map;
    }
    /*
    PathVariable,RequestHeader:springboot 底层都有一个kv均为String类型的Map，
     @RequestHeader Map<String,String> header， 可以使用默认的map 来获取all参数
      @PathVariable Map<String,String> pv,
      @RequestParam() Map<String,String> params
     */


    @PostMapping("/test")
    public Map<String,Object> postUser(@RequestBody() String content
                                       ){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);

        return map;
    }
}
