package com.qingmin.springbootdemo.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author code-yang
 * @date 2021/8/2 15:35
 * @Description
 * @Return
 * @Throws
 */
@Data
public class Human {

    // userName
    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;


}
