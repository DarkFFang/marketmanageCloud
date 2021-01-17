package com.fang.dataclient.controller;


import com.fang.dataclient.dao.PermissionMapper;
import com.fang.dataclient.dao.RoleMapper;
import com.fang.dataclient.dao.UserMapper;
import com.fang.dataclient.entity.User;
import com.fang.dataclient.entity.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 用户映射器
     */
    @Autowired
    private UserMapper userMapper;


    @GetMapping("/findUserByPhone")
    public User findUserByPhone(String phone) {
        return userMapper.findUserByPhone(phone);
    }

    /**
     * 添加新用户
     *
     * @param user 用户
     * @return int
     */
    @PostMapping("/addNewUser")
    public int addNewUser(@RequestBody User user) {
        return userMapper.addNewUser(user);
    }


    /**
     * 用户列表
     *
     * @return {@link List<UserVo>}
     */
    @GetMapping("/findUserList")
    public List<UserVo> findUserList() {
        return userMapper.findUserList();
    }

    /**
     * 通过id查询用户
     *
     * @param id id
     * @return {@link User}
     */
    @GetMapping("/findUserById")
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    /**
     * 通过id删除用户
     *
     * @param id id
     * @return int
     */
    @DeleteMapping("/deleteUserById")
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    /**
     * 通过id更新用户
     *
     * @param user 用户
     * @return int
     */
    @PutMapping("/updateUserById")
    public int updateUserById(@RequestBody User user) {
        return userMapper.updateUserById(user);
    }

    /**
     * 通过id更新用户角色
     *
     * @param id id
     * @return int
     */
    @PutMapping("/updateUserRoleById")
    public int updateUserRoleById(Integer id) {
        return userMapper.updateUserRoleById(id);
    }

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return {@link List<User>}
     */
    @GetMapping("/findUserByUsername")
    public List<User> findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    /**
     * 营业员列表
     *
     * @return {@link List<User>}
     */
    @GetMapping("/findClerkList")
    public List<User> findClerkList() {
        return userMapper.findClerkList();
    }

    /**
     * 库管员列表
     *
     * @return {@link List<User>}
     */
    @GetMapping("/findKeeperList")
    public List<User> findKeeperList() {
        return userMapper.findKeeperList();
    }

    /**
     * 通过id添加权限
     *
     * @return int
     */
    @PostMapping("/addPermissionById")
    public int addPermissionById() {
        return userMapper.addPermissionById();
    }

    /**
     * 通过id删除权限
     *
     * @return int
     */
    @DeleteMapping("/deletePermissionById")
    public int deletePermissionById() {
        return userMapper.deletePermissionById();
    }

    @GetMapping("/findPermissionById")
    public int findPermissionById() {
        return userMapper.findPermissionById();
    }

    @PutMapping("/alterUserAutoIncrement")
    public void alterUserAutoIncrement() {
        userMapper.alterUserAutoIncrement();
    }

}
