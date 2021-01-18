package com.fang.dataclient.controller;


import com.fang.dataclient.dao.UnitMapper;
import com.fang.dataclient.entity.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 单位服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
@RequestMapping("unit")
public class UnitController {
    /**
     * 设备映射器
     */
    @Autowired
    private UnitMapper unitMapper;

    /**
     * 添加新单位
     *
     * @param unit 单位
     * @return int
     */
    @PostMapping("/addNewUnit")
    public int addNewUnit(@RequestBody Unit unit) {
        return unitMapper.addNewUnit(unit);
    }

    /**
     * 找到单位列表
     *
     * @return {@link List<Unit>}
     */
    @GetMapping("/findUnitList")
    public List<Unit> findUnitList() {
        return unitMapper.findUnitList();
    }

    @PutMapping("/alterAutoIncrement")
    public void alterAutoIncrement(){
        unitMapper.alterAutoIncrement();
    }

}
