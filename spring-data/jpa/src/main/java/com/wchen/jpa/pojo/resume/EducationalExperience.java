package com.wchen.jpa.pojo.resume;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

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
@Table(name = "w_education_experience")
@Entity
public class EducationalExperience implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 简历标识
     */


    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 专业描述
     */
    private String description;

    @ManyToOne(targetEntity = Resume.class, cascade = CascadeType.MERGE)
    @JoinColumn(name="resume", referencedColumnName = "resume_id")
    private Resume resume;


}
