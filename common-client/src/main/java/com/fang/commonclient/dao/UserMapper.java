package com.fang.commonclient.dao;

import com.fang.commonclient.entity.User;
import com.fang.commonclient.entity.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口 {@code UserMapper} 用户表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient("data-client")
@RequestMapping("/user")
public interface UserMapper {

    /**
     * 增加用户（营业员或库管员）
     * @param user
     * @return
     */
    @PostMapping("/addNewUser")
    int addNewUser(User user);

    /**
     * 用户列表（营业员和库管员）
     * @return
     */
    @GetMapping("/findUserList")
    List<UserVo> findUserList();

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    @GetMapping("/findUserById")
    User findUserById(Integer id);

    /**
     * 删除用户（营业员或库管员）
     * @param id
     * @return
     */
    @DeleteMapping("/deleteUserById")
    int deleteUserById(Integer id);

    /**
     * 修改用户（营业员或库管员）
     * @param user
     * @return
     */
    @PutMapping("/updateUserById")
    int updateUserById(User user);

    /**
     * 修改用户（营业员或库管员）
     * @param id
     * @return
     */
    @PutMapping("/updateUserRoleById")
    int updateUserRoleById(Integer id);

    /**
     * 通过用户名（营业员或库管员）查询用户
     * @param username
     * @return
     */
    List<User> findUserByUsername(String username);

    /**
     * 通过电话查找用户
     * @param phone
     * @return
     */
    @GetMapping("/findUserByPhone")
    User findUserByPhone(String phone);

    /**
     * 搜索营业员列表
     * @return
     */
    List<User> findClerkList();

    /**
     * 搜索库管员列表
     * @return
     */
    List<User> findKeeperList();

    /**
     * 增加用户权限
     * @return
     */
    int addPermissionById();

    /**
     * 删除用户权限
     * @return
     */
    int deletePermissionById();

    /**
     * 查询用户权限
     * @return
     */
    int findPermissionById();

    /**
     * 更新主键自增ID
     */
    @PutMapping("/alterUserAutoIncrement")
    void alterUserAutoIncrement();

}
