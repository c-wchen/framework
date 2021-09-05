package com.wchen.security.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
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
@Table(name = "w_user")
@Entity
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一标识
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userId;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;
    /**
     * 邮箱
     */
    @Column(unique = true)
    private String userName;

    /**
     * 密码进行加盐
     */
    @Column(name = "salt")
    private String salt;

    private Short locked;



    @ManyToMany(fetch = FetchType.EAGER)
    List<Role> roles = new LinkedList<>();

}
