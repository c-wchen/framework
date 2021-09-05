package com.wchen;


import com.wchen.pojo.Student;
import com.wchen.pojo.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.wchen.pojo")
public class JavaConfig {
    @Bean
    public Teacher teacher() {
        return new Teacher("zhang", 33);
    }
}
