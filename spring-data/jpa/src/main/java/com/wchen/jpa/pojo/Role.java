package com.wchen.jpa.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    private String roleName;

    @OneToMany(targetEntity = Permission.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    /**
     * 维护外键  JoinColumn
     *  1. name: 外键名称
     *  2. referencedColumnName: 本表外键属性
     */
    @JoinColumn(name = "permission_role_id", referencedColumnName = "role_id")
    private List<Permission> permissions = new ArrayList<>();
}
