package com.fang.commonclient.dao;

import com.fang.commonclient.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
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
@FeignClient("data-client")
@RequestMapping("/sysLog")
public interface SysLogMapper {

    /**
     * 增加系统日志
     * @param sysLog
     * @return
     */
    @PostMapping("/addNewSysLog")
    int addNewSysLog(SysLog sysLog);

    /**
     * 增加登录日志
     * @param sysLog
     * @return
     */
    @PostMapping("/addNewLoginLog")
    int addNewLoginLog(SysLog sysLog);

    /**
     * 系统日志列表
     * @return
     */
    @GetMapping("/findSysLogList")
    List<SysLog> findSysLogList();

    /**
     * 登录日志列表
     * @return
     */
    @GetMapping("/findLoginLogList")
    List<SysLog> findLoginLogList();

    @DeleteMapping("/deleteAllSysLog")
    int deleteAllSysLog();
    @DeleteMapping("/deleteAllLoginLog")
    int deleteAllLoginLog();
}
