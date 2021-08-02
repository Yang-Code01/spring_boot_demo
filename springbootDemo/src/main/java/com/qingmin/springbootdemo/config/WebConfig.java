package com.qingmin.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/**
 * @author code-yang
 * @date 2021/7/31 22:50
 * @Description
 * @Return
 * @Throws
 */
@Configuration(proxyBeanMethods = false)
public class WebConfig {

//    自定义 表单请求的 hiddenHttpMethod 请求参数过滤规则
    @Bean
    public HiddenHttpMethodFilter httpMethodFilter(){
        HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
        filter.setMethodParam("_m");
        return filter;
    }
}
