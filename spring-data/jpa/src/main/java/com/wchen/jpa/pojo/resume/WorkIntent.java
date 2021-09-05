package com.wchen.jpa.pojo.resume;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "w_work_intent")
@Entity
public class WorkIntent implements Serializable {

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
     * 期望薪资
     */
    private BigDecimal expectedSalary;

    /**
     * 期望工作地点
     */
    private String expectedAddress;

    /**
     * 岗位
     */
    private String post;

    @ManyToOne(targetEntity = Resume.class, cascade = CascadeType.MERGE)
    @JoinColumn(name="resume", referencedColumnName = "resume_id")
    private Resume resume;


}
