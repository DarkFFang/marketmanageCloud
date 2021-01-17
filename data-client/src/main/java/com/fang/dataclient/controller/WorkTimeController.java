package com.fang.dataclient.controller;


import com.fang.dataclient.dao.WorkTimeMapper;
import com.fang.dataclient.entity.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 工作时间服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
public class WorkTimeController {
    /**
     * 工作时间映射器
     */
    @Autowired
    private WorkTimeMapper workTimeMapper;

    /**
     * 添加新的工作时间
     *
     * @param worktime 想出
     * @return int
     */
    @PostMapping("/addNewWorkTime")
    public int addNewWorkTime(WorkTime worktime){return workTimeMapper.addNewWorkTime(worktime);}

    /**
     * 通过id删除工作时间
     *
     * @param id id
     * @return int
     */
    @DeleteMapping("/deleteWorkTimeById")
    public int deleteWorkTimeById(Integer id){return workTimeMapper.deleteWorkTimeById(id);}

    /**
     * 通过id更新工作时间
     *
     * @param worktime 工作时间
     * @return int
     */
    @PutMapping("/updateWorkTimeById")
    public int updateWorkTimeById(WorkTime worktime){return workTimeMapper.updateWorkTimeById(worktime);}

    /**
     * 工作时间列表
     *
     * @return {@link List<WorkTime>}
     */
    @GetMapping("/findWorkTimeList")
    public List<WorkTime> findWorkTimeList(){return workTimeMapper.findWorkTimeList();}

    /**
     * 按用户名搜索工作时间
     *
     * @param username 用户名
     * @return {@link List<WorkTime>}
     */
    public List<WorkTime> searchWorkTimeByUsername(String username){return null;}

}
