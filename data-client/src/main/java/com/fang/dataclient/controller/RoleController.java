package com.fang.dataclient.controller;


import com.fang.dataclient.dao.PermissionMapper;
import com.fang.dataclient.dao.RoleMapper;
import com.fang.dataclient.entity.Permission;
import com.fang.dataclient.entity.Role;
import com.fang.dataclient.entity.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
public class RoleController {
    /**
     * 角色映射器
     */
    @Autowired
    private RoleMapper roleMapper;
    /**
     * 权限映射器
     */
    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 所有的角色列表
     *
     * @return {@link List<Role>}
     */
    @GetMapping("/findAllRole")
    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }

    /**
     * 通过用户id找到角色
     *
     * @param id id
     * @return {@link List<Role>}
     */
    @GetMapping("/findRolesByUserId")
    public List<Role> findRolesByUserId(Integer id) {
        return roleMapper.findRolesByUserId(id);
    }

    /**
     * 添加新角色
     *
     * @param role 角色
     * @return int
     */
    @PostMapping("/addNewRole")
    public int addNewRole(Role role) {
        return roleMapper.addNewRole(role);
    }

    /**
     * 通过id更新角色
     *
     * @param role 角色
     * @return int
     */
    @PutMapping("/updateRoleById")
    public int updateRoleById(Role role) {
        return roleMapper.updateRoleById(role);
    }

    /**
     * 通过id删除角色
     *
     * @param id id
     * @return int
     */
    @DeleteMapping("/deleteRoleById")
    public int deleteRoleById(Integer id) {
        return roleMapper.deleteRoleById(id);
    }

    /**
     * 更新用户角色
     *
     * @param userid 用户编号
     * @param roleid roleid
     * @return int
     */
    @PutMapping("/updateUserRole")
    public int updateUserRole(Integer userid, Integer roleid) {
        roleMapper.deleteUserRoleByUserId(userid);
        return roleMapper.addNewUserRole(userid, roleid);
    }


    /**
     * 添加新用户角色
     *
     * @param userid 用户编号
     * @param roleid roleid
     * @return int
     */
    @PostMapping("/addNewUserRole")
    public int addNewUserRole(Integer userid, Integer roleid) {
        return roleMapper.addNewUserRole(userid, roleid);
    }

    /**
     * 通过用户id删除用户角色
     *
     * @param userid 用户标识
     * @return int
     */
    @DeleteMapping("/deleteUserRoleByUserId")
    public int deleteUserRoleByUserId(Integer userid) {
        return roleMapper.deleteUserRoleByUserId(userid);
    }

    /**
     * 通过用户id找到权限
     *
     * @param id id
     * @return {@link List<Permission>}
     */
    @GetMapping("/findPermissionsByUserId")
    public List<Permission> findPermissionsByUserId(Integer id) {
        return permissionMapper.findPermissionsByUserId(id);
    }

    /**
     * 通过角色id查找权限
     *
     * @param roleid roleid
     * @return {@link List<PermissionVo>}
     */
    @GetMapping("/findPermissionsByRoleId")
    public List<PermissionVo> findPermissionsByRoleId(Integer roleid) {
        return permissionMapper.findPermissionsByRoleId(roleid);
    }

    /**
     * 通过用户id找到菜单
     *
     * @param id id
     * @return {@link List<PermissionVo>}
     */
    @GetMapping("/findMenuByUserId")
    public List<PermissionVo> findMenuByUserId(Integer id) {
        return permissionMapper.findMenuByUserId(id);
    }

    /**
     * 所有的权限列表
     *
     * @return {@link List<PermissionVo>}
     */
    @GetMapping("/findAllPermissions")
    public List<PermissionVo> findAllPermissions() {
        return permissionMapper.findAllPermissions();
    }

    /**
     * 添加新角色权限
     *
     * @param roleid        roleid
     * @param permissionids permissionids
     * @return int
     */
    @PostMapping("/addNewRolePermissions")
    public int addNewRolePermissions(Integer roleid, Integer[] permissionids) {
        return permissionMapper.addNewRolePermissions(roleid, permissionids);
    }

    /**
     * 更新角色权限
     *
     * @param roleid        roleid
     * @param permissionids permissionids
     * @return int
     */
    @PutMapping("/updateRolePermissions")
    public int updateRolePermissions(Integer roleid, Integer[] permissionids) {
        permissionMapper.deleteRolePermissionByRoleId(roleid);
        return permissionMapper.addNewRolePermissions(roleid, permissionids);
    }

    /**
     * 通过角色id删除角色权限
     *
     * @param roleid roleid
     * @return int
     */
    @DeleteMapping("/deleteRolePermissionByRoleId")
    public int deleteRolePermissionByRoleId(Integer roleid) {
        return permissionMapper.deleteRolePermissionByRoleId(roleid);
    }
}
