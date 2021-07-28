package com.qingmin.springbootdemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author code-yang
 * @date 2021/7/28 22:25
 * @Description
 * @Return
 * @Throws
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    // name
    private String name;


    // age
    private Integer age;

    private Pet pet;



}
