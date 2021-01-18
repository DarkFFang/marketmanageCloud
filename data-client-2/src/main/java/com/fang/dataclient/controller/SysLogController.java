package com.fang.dataclient.controller;


import com.fang.dataclient.dao.SysLogMapper;
import com.fang.dataclient.entity.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统日志服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
@RequestMapping("/sysLog")
public class SysLogController {
    /**
     * 系统日志映射器
     */
    @Autowired
    private SysLogMapper sysLogMapper;

    /**
     * 添加新系统日志
     *
     * @param sysLog 系统日志
     * @return int
     */
    @PostMapping("/addNewSysLog")
    public int addNewSysLog(@RequestBody SysLog sysLog) {
        return sysLogMapper.addNewSysLog(sysLog);
    }

    /**
     * 添加新的登录日志
     *
     * @param sysLog 系统日志
     * @return int
     */
    @PostMapping("/addNewLoginLog")
    public int addNewLoginLog(@RequestBody SysLog sysLog) {
        return sysLogMapper.addNewLoginLog(sysLog);
    }

    /**
     * 系统日志列表
     *
     * @return {@link List<SysLog>}
     */
    @GetMapping("/findSysLogList")
    public List<SysLog> findSysLogList() {
        return sysLogMapper.findSysLogList();
    }

    /**
     * 登录日志列表
     *
     * @return {@link List<SysLog>}
     */
    @GetMapping("/findLoginLogList")
    public List<SysLog> findLoginLogList() {
        return sysLogMapper.findLoginLogList();
    }

    @DeleteMapping("/deleteAllSysLog")
    public int deleteAllSysLog() {
        return sysLogMapper.deleteAllSysLog();
    }

    @DeleteMapping("/deleteAllLoginLog")
    public int deleteAllLoginLog() {
        return sysLogMapper.deleteAllLoginLog();
    }
}
