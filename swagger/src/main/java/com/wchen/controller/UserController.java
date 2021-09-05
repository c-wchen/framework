package com.wchen.controller;

import com.wchen.pojo.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
/**
 * 用户控制层
 */

@Api
public class UserController {
    /**
     * 添加用户
     * @param user 用户实体
     * @return 是否添加成功
     */
    @ApiOperation(value = "添加用户", notes = "获取用户信息，添加到数据库")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "user", type = "User",value = "用户信息")
    })
    @PostMapping("/add")
    public boolean addUser(@RequestBody User user) {
        return false;
    }

    /**
     * 通过id查询用户
     * @param id  用户id
     * @return   用户
     */
    @ApiOperation(value = "获取用户", notes = "通过Id获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", type = "int",value = "用户ID")
    })
    @GetMapping("/find/{id}")
    public User findById(@PathVariable("id") int id) {
        return new User();
    }

    /**
     * 更新用户数据
     * @param user 用户
     * @return  是否更新成功
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", type = "User",value = "用户信息")
    })
    @ApiOperation(value = "更新用户", notes = "获取用户信息,通过ID进行更新")
    @PutMapping("/update")
    public boolean update(@RequestBody User user) {
        return true;
    }

    /**
     * 根据id删除用户
     * @param id  用户id
     * @return    是否删除成功
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", type = "int",value = "用户ID")
    })
    @ApiOperation(value = "删除用户", notes = "根据用户ID进行删除用户")
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return true;
    }
}