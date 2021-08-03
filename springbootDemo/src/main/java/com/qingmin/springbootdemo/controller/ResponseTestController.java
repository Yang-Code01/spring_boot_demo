package com.qingmin.springbootdemo.controller;

import com.qingmin.springbootdemo.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author code-yang
 * @date 2021/8/3 20:56
 * @Description
 * @Return
 * @Throws
 */
@Controller
public class ResponseTestController {


    /**
     * 1、浏览器发请求直接返回xml  【application/xml】    jacksonXmlConverter
     * 2、如果使ajax 请求，返回  json   【application/json】  jasksonJsonConverter
     * 2、如果是app 发请求，返回自定义协议数据， 【application/x-qingmin】    xxxQingMinConverter
     *  属性值1；属性值2
     * 步骤：
     * 1、添加自定义的MessageConverter 到 系统底层
     * 2、系统底层就会统计出所有MessageConverter能操作那些类型
     * 3、客户端内容协调【qingMin --->  QingMIi】
     * 实现：
     * 1、实现HttpMessageConverter 这个接口，实现所有方法，canWrite()设置为true ，getSupportedMediaTypes（）'
     * 加入自定义的转换MediaType,write()通过这个方法写出数据
     * 2、需要再我们的Webconfier中配置extendMessageConverters（）
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(22);
        person.setBirth(new Date());
        person.setUsername("zhangshan");
        return person;
    }
}
