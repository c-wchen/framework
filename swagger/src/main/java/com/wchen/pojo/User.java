package com.wchen.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class User {
    @ApiModelProperty(name = "用户名", notes = "真实姓名")
    private String name;
    @ApiModelProperty(name = "年龄", notes = "0-99之间")
    private Integer age;
    public User() {
    }
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
