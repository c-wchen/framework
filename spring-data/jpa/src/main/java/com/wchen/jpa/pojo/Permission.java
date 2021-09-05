package com.wchen.jpa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    private String permissionName;

    private String url;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "permission_role_id", referencedColumnName = "role_id")
    private Role role;

}
