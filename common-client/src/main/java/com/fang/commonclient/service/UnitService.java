package com.fang.commonclient.service;

import com.fang.commonclient.entity.Unit;

import java.util.List;

/**
 * 服务 {@code UnitService} 商品单位表.
 *
 * @author fang
 * @since 2020/12/14
 */
public interface UnitService {

    /**
     * 增加商品单位
     * @param unit
     * @return
     */
    int addNewUnit(Unit unit);

    /**
     * 商品单位列表
     * @return
     */
    List<Unit> findUnitList();

}
