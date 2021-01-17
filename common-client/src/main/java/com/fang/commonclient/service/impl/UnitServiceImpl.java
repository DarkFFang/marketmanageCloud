package com.fang.commonclient.service.impl;

import com.fang.commonclient.dao.UnitMapper;
import com.fang.commonclient.entity.Unit;
import com.fang.commonclient.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 单位服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@Service
public class UnitServiceImpl implements UnitService {
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
    @Override
    public int addNewUnit(Unit unit) {
        return unitMapper.addNewUnit(unit);
    }

    /**
     * 找到单位列表
     *
     * @return {@link List<Unit>}
     */
    @Override
    public List<Unit> findUnitList() {
        return unitMapper.findUnitList();
    }

}
