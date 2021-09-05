package com.wchen.jpa.pojo.resume;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


/**
 * <p>
 * 
 * </p>
 *
 * @author wchen
 * @since 2021-04-16
 */
@Data
    @EqualsAndHashCode(callSuper = false)
@Table(name = "w_resume")
@Entity
public class Resume implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 简历标识
     */
    @Id
    @Column(name = "resume_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resumeId;
    /**
     * 简历别名
     */
    private String alias;

    /**
     * 0:男, 1:女
     */
    private Integer sex;

    /**
     * 出生日期
     */
    private LocalDateTime birthday;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 居住地址
     */
    private String address;

    /**
     * 自我评价
     */
    private String evaluation;

    /**
     * 简历头像
     */
    private String avatar;

    /**
     * 简历所属用户
     */
    private Long userId;

    @OneToMany(targetEntity = EducationalExperience.class, cascade = CascadeType.ALL)
    @JoinColumn(name="resume", referencedColumnName = "resume_id")
    List<EducationalExperience> educationalExperiences = new LinkedList<>();


    @OneToMany(targetEntity = ProjectExperience.class, cascade = CascadeType.ALL)
    @JoinColumn(name="resume", referencedColumnName = "resume_id")
    List<ProjectExperience> projectExperiences = new LinkedList<>();


    @OneToMany(targetEntity = WorkIntent.class, cascade = CascadeType.ALL)
    @JoinColumn(name="resume", referencedColumnName = "resume_id")
    List<WorkIntent> workIntents =  new LinkedList<>();


    @OneToMany(targetEntity = WorkExperience.class, cascade = CascadeType.ALL)
    @JoinColumn(name="resume", referencedColumnName = "resume_id")
    List<WorkExperience> workExperiences = new LinkedList<>();
}
