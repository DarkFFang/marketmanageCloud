package com.fang.commonclient.dao;

import com.fang.commonclient.entity.Permission;
import com.fang.commonclient.entity.vo.PermissionVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口 {@code PermissionMapper} 权限表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient(value = "data-client",contextId = "PermissionMapper")
public interface PermissionMapper {

    /**
     * 通过用户编号查询权限
     * @param id
     * @return
     */
    @GetMapping("/permission/findPermissionsByUserId")
    List<Permission> findPermissionsByUserId(@RequestParam Integer id);

    /**
     * 通过角色编号查询权限
     * @param id
     * @return
     */
    @GetMapping("/permission/findPermissionsByRoleId")
    List<PermissionVo> findPermissionsByRoleId(@RequestParam Integer id);

    /**
     * 权限列表
     * @return
     */
    @GetMapping("/permission/findAllPermissions")
    List<PermissionVo> findAllPermissions();

    /**
     * 通过用户编号查询用户菜单
     * @param id
     * @return
     */
    @GetMapping("/permission/findMenuByUserId")
    List<PermissionVo> findMenuByUserId(@RequestParam Integer id);

    /**
     * 添加角色权限
     * @param roleid
     * @param permissionids
     * @return
     */
    @PostMapping("/permission/addNewRolePermissions")
    int addNewRolePermissions(@RequestParam Integer roleid,@RequestParam Integer[] permissionids);

    /**
     * 通过角色编号删除角色权限
     * @param roleid
     * @return
     */
    @DeleteMapping("/permission/deleteRolePermissionByRoleId")
    int deleteRolePermissionByRoleId(@RequestParam Integer roleid);
}
