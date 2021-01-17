package com.fang.commonclient.dao;

import com.fang.commonclient.entity.Permission;
import com.fang.commonclient.entity.vo.PermissionVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 接口 {@code PermissionMapper} 权限表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient("data-client")
@RequestMapping("/Permission")
public interface PermissionMapper {

    /**
     * 通过用户编号查询权限
     * @param id
     * @return
     */
    @GetMapping("/findPermissionsByUserId")
    List<Permission> findPermissionsByUserId(Integer id);

    /**
     * 通过角色编号查询权限
     * @param id
     * @return
     */
    @GetMapping("/findPermissionsByRoleId")
    List<PermissionVo> findPermissionsByRoleId(Integer id);

    /**
     * 权限列表
     * @return
     */
    @GetMapping("/findAllPermissions")
    List<PermissionVo> findAllPermissions();

    /**
     * 通过用户编号查询用户菜单
     * @param id
     * @return
     */
    @GetMapping("/findMenuByUserId")
    List<PermissionVo> findMenuByUserId(Integer id);

    /**
     * 添加角色权限
     * @param roleid
     * @param permissionids
     * @return
     */
    @PostMapping("/addNewRolePermissions")
    int addNewRolePermissions(Integer roleid, Integer[] permissionids);

    /**
     * 通过角色编号删除角色权限
     * @param roleid
     * @return
     */
    @DeleteMapping("/deleteRolePermissionByRoleId")
    int deleteRolePermissionByRoleId(Integer roleid);
}
