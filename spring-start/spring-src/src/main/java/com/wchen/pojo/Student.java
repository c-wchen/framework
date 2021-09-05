package com.wchen.pojo;

import java.util.*;

public class Student {
    private String name;
    private Integer age;
    private Integer[] arr;
    private Map<String, String> map;
    private Set<String> set;
    private List<String> list;
    private Properties properties;

    static {
        System.out.println("=========== load student =====");
    }

    public Student() {

    }




    public Student(String name, Integer age, Integer[] arr, Map<String, String> map, Set<String> set, List<String> list) {
        this.name = name;
        this.age = age;
        this.arr = arr;
        this.map = map;
        this.set = set;
        this.list = list;
    }


    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
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

    public Integer[] getArr() {
        return arr;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", arr=" + Arrays.toString(arr) +
                ", map=" + map +
                ", set=" + set +
                ", list=" + list +
                ", properties=" + properties +
                '}';
    }
}
