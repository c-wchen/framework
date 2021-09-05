package com.wchen.pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



@SuppressWarnings("all")
public class People {
    private String name;
    private Integer age;
    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
