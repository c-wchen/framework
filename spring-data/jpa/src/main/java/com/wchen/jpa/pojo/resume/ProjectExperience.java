package com.wchen.jpa.pojo.resume;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = "w_project_experience")
@Entity
public class ProjectExperience implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 项目描述
     */
    private String description;

    @ManyToOne(targetEntity = Resume.class)
    @JoinColumn(name="resume", referencedColumnName = "resume_id")
    private Resume resume;


}
