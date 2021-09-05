package com.wchen.jpa;

import com.wchen.jpa.dao.resume.ResumeMapper;
import com.wchen.jpa.pojo.resume.EducationalExperience;
import com.wchen.jpa.pojo.resume.Resume;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testTables {
    @Autowired
    ResumeMapper resumeMapper;

    @Test
    public void testGen() {
        System.out.println("hello world");
    }

    @Test
    public void save() {

        Resume resume = new Resume();
        resume.setAddress("chen");
        EducationalExperience educationalExperience = new EducationalExperience();
        educationalExperience.setDescription("zhe shi yi ge ce shi");
        resume.getEducationalExperiences().add(educationalExperience);
        resumeMapper.save(resume);


        System.out.println(resumeMapper.count());

    }
    @Test
    public void testDelete() {
        resumeMapper.deleteById(2L);

    }


}
