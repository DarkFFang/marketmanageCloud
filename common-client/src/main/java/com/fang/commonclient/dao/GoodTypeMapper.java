package com.fang.commonclient.dao;

import com.fang.commonclient.entity.GoodType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口 {@code GoodTypeMapper} 商品类型表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient(value = "data-client",contextId = "GoodTypeMapper")
public interface GoodTypeMapper {
    /**
     * 增加用户类型
     * @param goodType
     * @return
     */
    @PostMapping("/goodType/addNewGoodType")
    int addNewGoodType(@RequestBody GoodType goodType);

    /**
     * 商品类型列表
     * @return
     */
    @GetMapping("/goodType/findGoodTypeList")
    List<GoodType> findGoodTypeList();

    /**
     * 更新主键自增ID
     */
    @PutMapping("/goodType/alterAutoIncrement")
    void alterAutoIncrement();
}
