package com.fang.commonclient.dao;

import com.fang.commonclient.entity.Unit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口 {@code UnitMapper} 商品单位表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient(value = "data-client",contextId = "UnitMapper")
public interface UnitMapper {

    /**
     * 增加商品单位
     * @param unit
     * @return
     */
    @PostMapping("/unit/addNewUnit")
    int addNewUnit(@RequestBody Unit unit);

    /**
     * 商品单位列表
     * @return
     */
    @GetMapping("/unit/findUnitList")
    List<Unit> findUnitList();

    /**
     * 更新主键自增ID
     */
    @PutMapping("/unit/alterAutoIncrement")
    void alterAutoIncrement();
}
