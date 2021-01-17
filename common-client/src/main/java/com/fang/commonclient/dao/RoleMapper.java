package com.fang.commonclient.dao;

import com.fang.commonclient.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口 {@code RoleMapper} 角色表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient(value = "data-client",contextId = "RoleMapper")
public interface RoleMapper {

    /**
     * 通过用户编号查询用户权限
     * @param id
     * @return
     */
    @GetMapping("/role/findRolesByUserId")
    List<Role> findRolesByUserId(@RequestParam Integer id);

    /**
     * 查询所有权限列表
     * @return
     */
    @GetMapping("/role/findAllRole")
    List<Role> findAllRole();

    /**
     * 添加新角色
     * @param role
     * @return
     */
    @PostMapping("/role/addNewRole")
    int addNewRole(@RequestBody Role role);

    /**
     * 修改角色权限
     * @param role
     * @return
     */
    @PutMapping("/role/updateRoleById")
    int updateRoleById(@RequestBody Role role);

    /**
     * 删除角色
     * @param id
     * @return
     */
    @DeleteMapping("/role/deleteRoleById")
    int deleteRoleById(@RequestParam Integer id);

    /**
     * 添加角色权限
     * @param userid
     * @param roleid
     * @return
     */
    @PostMapping("/role/addNewUserRole")
    int addNewUserRole(@RequestParam Integer userid,@RequestParam Integer roleid);

    /**
     * 删除角色权限
     * @param userid
     * @return
     */
    @DeleteMapping("/role/deleteUserRoleByUserId")
    int deleteUserRoleByUserId(@RequestParam Integer userid);

}
