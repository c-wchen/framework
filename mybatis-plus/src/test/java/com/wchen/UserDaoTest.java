package com.wchen;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wchen.dao.UserDao;
import com.wchen.pojo.User;
import com.wchen.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;
    @Test
    public void testQuery() {
        List<User> users = userDao.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("chen");
        user.setPassword("123");
        for (int i = 0; i < 100; i++) {
            userDao.insert(user);
        }
    }
    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserId(532688061524889665L);
        user.setPassword("1212");
        userDao.updateById(user);
    }

    @Test
    public void testPage() {
        Page<User> page = new Page<>(2, 5);

        userDao.selectPage(page, null);
        System.out.println(page.getTotal());
        page.getRecords().forEach(System.out::println);

    }

    @Test
    public void testDelete() {
        int i = userDao.deleteBatchIds(Arrays.asList(532688061524889663L, 532688061524889664L));
        Assert.assertEquals(i,2);
    }
    @Test
    public void testLogicDelete() {
        userDao.deleteById(532688061524889665L);
    }

    @Test
    public void testSelectAll() {
        userDao.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testWrapper() {
        LambdaQueryWrapper<User>  lambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<User> select = lambdaQueryWrapper.ge(User::getUserId, 1L);
        System.out.println(userDao.selectList(lambdaQueryWrapper));
    }
}
