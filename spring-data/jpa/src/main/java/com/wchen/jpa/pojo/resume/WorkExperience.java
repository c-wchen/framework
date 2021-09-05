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
@Table(name = "w_work_experience")
@Entity
public class WorkExperience implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 公司
     */
    private String company;

    /**
     * 职位
     */
    private String position;

    /**
     * 工作描述
     */
    private String description;

    @ManyToOne(targetEntity = Resume.class)
    @JoinColumn(name="resume", referencedColumnName = "resume_id")
    private Resume resume;


}
