package com.fang.commonclient.dao;

import com.fang.commonclient.entity.User;
import com.fang.commonclient.entity.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口 {@code UserMapper} 用户表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient(value = "data-client",contextId = "userMapper")
public interface UserMapper {

    /**
     * 增加用户（营业员或库管员）
     * @param user
     * @return
     */
    @PostMapping("/user/addNewUser")
    int addNewUser(@RequestBody User user);

    /**
     * 用户列表（营业员和库管员）
     * @return
     */
    @GetMapping("/user/findUserList")
    List<UserVo> findUserList();

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    @GetMapping("/user/findUserById")
    User findUserById(@RequestParam Integer id);

    /**
     * 删除用户（营业员或库管员）
     * @param id
     * @return
     */
    @DeleteMapping("/user/deleteUserById")
    int deleteUserById(@RequestParam Integer id);

    /**
     * 修改用户（营业员或库管员）
     * @param user
     * @return
     */
    @PutMapping("/user/updateUserById")
    int updateUserById(@RequestBody User user);

    /**
     * 修改用户（营业员或库管员）
     * @param id
     * @return
     */
    @PutMapping("/user/updateUserRoleById")
    int updateUserRoleById(@RequestParam Integer id);

    /**
     * 通过用户名（营业员或库管员）查询用户
     * @param username
     * @return
     */
//    List<User> findUserByUsername(String username);

    /**
     * 通过电话查找用户
     * @param phone
     * @return
     */
    @GetMapping("/user/findUserByPhone")
    User findUserByPhone(@RequestParam String phone);

    /**
     * 搜索营业员列表
     * @return
     */
//    List<User> findClerkList();

    /**
     * 搜索库管员列表
     * @return
     */
//    List<User> findKeeperList();

    /**
     * 增加用户权限
     * @return
     */
//    int addPermissionById();

    /**
     * 删除用户权限
     * @return
     */
//    int deletePermissionById();

    /**
     * 查询用户权限
     * @return
     */
//    int findPermissionById();

    /**
     * 更新主键自增ID
     */
    @PutMapping("/user/alterUserAutoIncrement")
    void alterUserAutoIncrement();

}
