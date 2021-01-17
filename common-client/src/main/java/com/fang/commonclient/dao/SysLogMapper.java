package com.fang.commonclient.dao;

import com.fang.commonclient.entity.SysLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 接口 {@code SysLogMapper} 日志表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient(value = "data-client",contextId = "SysLog")
public interface SysLogMapper {

    /**
     * 增加系统日志
     * @param sysLog
     * @return
     */
    @PostMapping("/sysLog/addNewSysLog")
    int addNewSysLog(SysLog sysLog);

    /**
     * 增加登录日志
     * @param sysLog
     * @return
     */
    @PostMapping("/sysLog/addNewLoginLog")
    int addNewLoginLog(SysLog sysLog);

    /**
     * 系统日志列表
     * @return
     */
    @GetMapping("/sysLog/findSysLogList")
    List<SysLog> findSysLogList();

    /**
     * 登录日志列表
     * @return
     */
    @GetMapping("/sysLog/findLoginLogList")
    List<SysLog> findLoginLogList();

    @DeleteMapping("/sysLog/deleteAllSysLog")
    int deleteAllSysLog();
    @DeleteMapping("/sysLog/deleteAllLoginLog")
    int deleteAllLoginLog();
}
