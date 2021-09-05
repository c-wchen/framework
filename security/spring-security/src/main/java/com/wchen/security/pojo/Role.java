package com.wchen.security.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "w_role")
@Entity
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 所属代码
     */
    private String code;


    @OneToMany(fetch = FetchType.EAGER)
    List<Permission> permissions;


}
