package com.qingmin.springbootdemo.controller;


import org.junit.platform.engine.support.descriptor.FileSystemSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author code-yang
 * @date 2021/8/2 9:48
 * @Description
 * @Return
 * @Throws
 */
@Controller
public class RequestController {

    @GetMapping("/goto")
    public String gotoPage(HttpServletRequest request,HttpSession session){
        request.setAttribute("msg","HTTP ServletRequest中的数据");
        request.setAttribute("code",1234);
        session.setAttribute("msg","Session 中的数据");

        return "redirect:success";// forward:
    }
    /*
    使用@RequsetAttribute(""),可以获取请求域中的数据
    如果是请求转发，也可从请求域中获取
    重定向则不行
     */
    @GetMapping("/success")
    @ResponseBody
    public Map success(//HttpServletRequest request,
                       //@RequestAttribute("msg") String msg1,
                       HttpSession session,
                       //@RequestAttribute("code") Integer code){
        //Object msg = request.getAttribute("msg"
                       HttpServletRequest request
                       ) {

        Object req = request.getAttribute("req");
        Object model = request.getAttribute("model");
        Object mapVa = request.getAttribute("map");



//        Object msg2 = session.getAttribute("msg");
       Map<String,Object> map = new HashMap<>();
        //map.put("code",code);
        //map.put("msg",msg);
        //map.put("msg1",msg1);
       // map.put("msg2",msg2);
        map.put("k1",model);
        map.put("k2",req);
        map.put("k3",mapVa);

        return map;
    }


    /*
    HttpServletRequest request, Model model, Map map都是放在请求参数中
    隐藏域
     */

    @GetMapping("/model")
    public String model(HttpServletRequest request, Model model, Map map){

        request.setAttribute("req","req参数");
        model.addAttribute("model","model参数");
        map.put("map","map参数");
        return "forward:success";
    }

    @ResponseBody // RequestResponseBodyMethodProcessor -->messageConverter  内容协商
    @GetMapping("/he11")
    public FileSystemSource file(){
        // 文件以这样的方式处理的（）
        return null;
    }

}
