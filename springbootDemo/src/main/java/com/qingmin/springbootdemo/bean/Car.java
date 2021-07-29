package com.qingmin.springbootdemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author code-yang
 * @date 2021/7/29 13:40
 * @Description
 * @Return
 * @Throws
 */
/*
@Component
@ConfigurationProperties(prefix = "mycar")
注册到容器中，然后组测
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {

    // Car brand
    private String brand;

    // price
    private Integer price;



}
