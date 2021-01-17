package com.fang.dataclient.controller;


import com.fang.dataclient.config.CustomGrantedAuthority;
import com.fang.dataclient.dao.PermissionMapper;
import com.fang.dataclient.dao.RoleMapper;
import com.fang.dataclient.dao.UserMapper;
import com.fang.dataclient.entity.JwtUser;
import com.fang.dataclient.entity.Permission;
import com.fang.dataclient.entity.User;
import com.fang.dataclient.entity.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
public class UserController {
    /**
     * 用户映射器
     */
    @Autowired
    UserMapper userMapper;

    /**
     * 角色映射器
     */
    @Autowired
    RoleMapper roleMapper;

    /**
     * 许可映射器
     */
    @Autowired
    PermissionMapper permissionMapper;


    /**
     * 加载用户的用户名
     *
     * @param phone 电话
     * @return {@link UserDetails}* @throws UsernameNotFoundException 用户名没有发现异常
     */
    @PostMapping("/loadUserByUsername")
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user=userMapper.findUserByPhone(phone);
        if(user == null){
            throw new UsernameNotFoundException(phone+"用户不存在！请联系管理员。");
        }
        List<Permission> permissions=permissionMapper.findPermissionsByUserId(user.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Permission permission : permissions) {
            if (permission != null && permission.getName() != null) {
                GrantedAuthority grantedAuthority = new CustomGrantedAuthority(permission.getUrl(), permission.getMethod());
                authorities.add(grantedAuthority);
            }
        }
        return new JwtUser(user.getId(),user.getUsername(),user.getPhone(),user.getPassword(),authorities);
    }

    /**
     * 添加新用户
     *
     * @param user 用户
     * @return int
     */
    @PostMapping("/addNewUser")
    public int addNewUser(User user) {
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
        int result=userMapper.deleteUserById(id);
        if (result == 1) {
            userMapper.alterUserAutoIncrement();
        }
        return result;
    }

    /**
     * 通过id更新用户
     *
     * @param user 用户
     * @return int
     */
    @PutMapping("/updateUserById")
    public int updateUserById(User user) {
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
    public List<User> findUserByUsername(String username) {
        return null;
    }

    /**
     * 营业员列表
     *
     * @return {@link List<User>}
     */
    public List<User> findClerkList() {
        return null;
    }

    /**
     * 库管员列表
     *
     * @return {@link List<User>}
     */
    public List<User> findKeeperList() {
        return null;
    }

    /**
     * 通过id添加权限
     *
     * @return int
     */
    public int addPermissionById() {
        return 0;
    }

    /**
     * 通过id删除权限
     *
     * @return int
     */
    public int deletePermissionById() {
        return 0;
    }

}
