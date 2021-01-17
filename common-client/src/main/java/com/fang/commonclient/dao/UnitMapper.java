package com.fang.commonclient.dao;

import com.fang.commonclient.entity.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 接口 {@code UnitMapper} 商品单位表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient("data-client")
@RequestMapping("/unit")
public interface UnitMapper {

    /**
     * 增加商品单位
     * @param unit
     * @return
     */
    @PostMapping("/addNewUnit")
    int addNewUnit(Unit unit);

    /**
     * 商品单位列表
     * @return
     */
    @GetMapping("/findUnitList")
    List<Unit> findUnitList();

    /**
     * 更新主键自增ID
     */
    @PutMapping
    void alterAutoIncrement();
}
