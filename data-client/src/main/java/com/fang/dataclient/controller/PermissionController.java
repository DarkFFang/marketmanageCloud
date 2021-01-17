package com.fang.dataclient.controller;

import com.fang.dataclient.dao.PermissionMapper;
import com.fang.dataclient.entity.Permission;
import com.fang.dataclient.entity.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionMapper permissionMapper;
    /**
     * 通过用户id找到权限
     *
     * @param id id
     * @return {@link List < Permission >}
     */
    @GetMapping("/findPermissionsByUserId")
    public List<Permission> findPermissionsByUserId(Integer id) {
        return permissionMapper.findPermissionsByUserId(id);
    }

    /**
     * 通过角色id查找权限
     *
     * @param roleid roleid
     * @return {@link List< PermissionVo >}
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
