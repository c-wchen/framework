package com.wchen.basic.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * +--------------------+       +------+   +------+   +---+   +-------+
 * | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
 * +--------------------+       +------+   +------+   +---+   +-------+
 */
public class SimpleStream {
    static class Person {
        private Integer age;
        private String name;
        private String sex;

        public Person(String name, Integer age, String sex) {
            this.age = age;
            this.name = name;
            this.sex = sex;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

    }
    public static List<Person> persons = new ArrayList<>();
    static {
        persons.add(new Person("wchen", 21, "男"));
        persons.add(new Person("yff", 18, "女"));
        persons.add(new Person("zqy", 20, "男"));
        persons.add(new Person("abc", 20, "女"));
        persons.add(new Person("abcd", 21, "男"));
    }

    public static void main(String[] args) {
        // 分组
        Map<String, Long> c1 = persons.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.counting()));
        System.out.println(c1);
        System.out.println("================");

        // 过滤
        persons.stream().filter(p-> p.getAge() > 20).forEach(System.out::println);
        System.out.println("================");

        // 分页
        persons.stream().limit(3).forEach(System.out::println);

        //计算数量
        System.out.println(persons.stream().map(p -> 1).reduce(Integer::sum).get());
        System.out.println(persons.stream().count());
        // 转换为数组
        System.out.println(persons.stream().toArray());

        // 数量不限
        IntStream.iterate(1, i -> i * 2).limit(20).forEach(System.out::println);
        // 扩展map
        System.out.println(persons.stream().flatMap(p -> Arrays.stream(p.getName().split(""))).distinct().collect(Collectors.toList()));


    }
}


