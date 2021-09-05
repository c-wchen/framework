package com.wchen.security.pojo;

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
@Table(name = "w_permission")
@Entity
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
    private Long permissionId;


    /**
     * 权限代码
     */
    @Column(unique = true)
    private String code;
    /**
     * 权限
     */
    @Column(unique = true)
    private String url;

    /**
     * 权限描述
     */
    private String description;
}
