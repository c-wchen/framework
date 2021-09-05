package com.wchen.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.Set;

@Component
public class Student {
    @Value("chen")
    private String name;
    @Value("21")
    private Integer age;
    @Autowired
    private Teacher teacher;

    public Student() {}


    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }
}
