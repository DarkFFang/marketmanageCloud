package com.fang.dataclient.controller;


import com.fang.dataclient.dao.SysLogMapper;
import com.fang.dataclient.entity.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统日志服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
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
    public int addNewSysLog(SysLog sysLog) {
        return sysLogMapper.addNewSysLog(sysLog);
    }

    /**
     * 添加新的登录日志
     *
     * @param sysLog 系统日志
     * @return int
     */
    public int addNewLoginLog(SysLog sysLog) {
        return sysLogMapper.addNewLoginLog(sysLog);
    }

    /**
     * 系统日志列表
     *
     * @return {@link List<SysLog>}
     */
    public List<SysLog> findSysLogList() {
        return sysLogMapper.findSysLogList();
    }

    /**
     * 登录日志列表
     *
     * @return {@link List<SysLog>}
     */
    public List<SysLog> findLoginLogList() {
        return sysLogMapper.findLoginLogList();
    }

    public int deleteAllSysLog() {
        return sysLogMapper.deleteAllSysLog();
    }

    public int deleteAllLoginLog() {
        return sysLogMapper.deleteAllLoginLog();
    }
}
