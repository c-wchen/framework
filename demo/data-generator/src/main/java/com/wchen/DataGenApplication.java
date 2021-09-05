package com.wchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataGenApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataGenApplication.class, args);
    }
    //public static void main(String[] args) {
    //    // 创建faker
    //    Faker faker = new Faker(new Locale("zh_CN"));
    //    // 生成姓名
    //    System.out.println(faker.name().fullName());
    //    // 生成地址
    //    System.out.println(faker.address().fullAddress());
    //
    //    //生成时间
    //    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //
    //    System.out.println(sdf.format(faker.date().between(new Date(1612939407), new Date(1618037007)).getTime()));
    //
    //    // 书籍
    //    System.out.println(faker.book().title());
    //}
}
