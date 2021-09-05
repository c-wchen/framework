package com.wchen.jpa.dao;

import com.wchen.jpa.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper extends JpaRepository<Role, Long> {
}
