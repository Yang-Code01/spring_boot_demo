package com.qingmin.springbootdemo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author code-yang
 * @date 2021/7/30 10:36
 * @Description
 * @Return
 * @Throws
 */
//@ConfigurationProperties(prefix = "person")

@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String username;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private Pet pet;
    private String[] interests;
    private List<String> animal;
    private Map<String,Object> score;
    private Set<Double> salaries;
    private Map<String,List<Pet>> allPets;
}
