package com.wchen;

import com.wchen.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentTest {
    @Test
    public void testStudent() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Student student = (Student) context.getBean("getStudent");
        System.out.println(student);
    }
}
