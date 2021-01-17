package com.fang.dataclient.controller;


import com.fang.dataclient.dao.UnitMapper;
import com.fang.dataclient.entity.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 单位服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
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
    public int addNewUnit(Unit unit) {
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

}
