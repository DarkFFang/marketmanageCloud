package com.fang.commonclient.dao;

import com.fang.commonclient.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口 {@code RoleMapper} 角色表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient("data-client")
@RequestMapping("/role")
public interface RoleMapper {

    /**
     * 通过用户编号查询用户权限
     * @param id
     * @return
     */
    @GetMapping("/findRolesByUserId")
    List<Role> findRolesByUserId(Integer id);

    /**
     * 查询所有权限列表
     * @return
     */
    @GetMapping("/findAllRole")
    List<Role> findAllRole();

    /**
     * 添加新角色
     * @param role
     * @return
     */
    @PostMapping("/addNewRole")
    int addNewRole(Role role);

    /**
     * 修改角色权限
     * @param role
     * @return
     */
    @PutMapping("/updateRoleById")
    int updateRoleById(Role role);

    /**
     * 删除角色
     * @param id
     * @return
     */
    @DeleteMapping("/deleteRoleById")
    int deleteRoleById(Integer id);

    /**
     * 添加角色权限
     * @param userid
     * @param roleid
     * @return
     */
    @PostMapping("/addNewUserRole")
    int addNewUserRole(Integer userid, Integer roleid);

    /**
     * 删除角色权限
     * @param userid
     * @return
     */
    @DeleteMapping("/deleteUserRoleByUserId")
    int deleteUserRoleByUserId(Integer userid);

}
