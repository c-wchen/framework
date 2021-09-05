package com.wchen.security.mapper;

import com.wchen.security.pojo.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wchen
 * @since 2021-04-16
 */
@Repository
public interface RoleMapper extends JpaRepository<Role, Long> {

}
