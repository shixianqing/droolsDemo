package com.drools.model;

/**
 * @Author:shixianqing
 * @Date:2019/3/12 10:39
 * @Description:
 **/
public class Person {

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
