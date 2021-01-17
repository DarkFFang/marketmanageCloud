package com.fang.commonclient.dao;

import com.fang.commonclient.entity.WorkTime;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口 {@code WorkTimeMapper} 工作时间表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient(value = "data-client",contextId = "WorkTime")
public interface WorkTimeMapper {

    /**
     * 增加时间表项
     * @param worktime
     * @return
     */
    @PostMapping("/workTime/addNewWorkTime")
    int addNewWorkTime(WorkTime worktime);

    /**
     * 删除时间表项
     * @param id
     * @return
     */
    @DeleteMapping("/workTime/deleteWorkTimeById")
    int deleteWorkTimeById(Integer id);

    /**
     * 修改时间表项
     * @param worktime
     * @return
     */
    @PutMapping("/workTime/updateWorkTimeById")
    int updateWorkTimeById(WorkTime worktime);

    /**
     * 时间表列表
     * @return
     */
    @GetMapping("/workTime/findWorkTimeList")
    List<WorkTime> findWorkTimeList();

    /**
     * 通过姓名查询时间表列表
     * @param username
     * @return
     */
//    List<WorkTime> searchWorkTimeByUsername(String username);

    /**
     * 查询营业员时间表列表
     * @return
     */
//    List<WorkTime> findClerkTime();

    /**
     * 查询库管员时间表列表
     * @return
     */
//    List<WorkTime> findKeeperTime();
}
