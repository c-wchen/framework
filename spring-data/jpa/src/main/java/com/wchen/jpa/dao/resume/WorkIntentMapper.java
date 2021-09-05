package com.wchen.jpa.dao.resume;

import com.wchen.jpa.pojo.resume.WorkIntent;
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
public interface WorkIntentMapper extends JpaRepository<WorkIntent, Long> {

}
