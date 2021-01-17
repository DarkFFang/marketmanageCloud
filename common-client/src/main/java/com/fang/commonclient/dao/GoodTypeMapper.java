package com.fang.commonclient.dao;

import com.fang.commonclient.entity.GoodType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 接口 {@code GoodTypeMapper} 商品类型表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient("data-client")
@RequestMapping("/goodType")
public interface GoodTypeMapper {
    /**
     * 增加用户类型
     * @param goodType
     * @return
     */
    @PostMapping("/addNewGoodType")
    int addNewGoodType(GoodType goodType);

    /**
     * 商品类型列表
     * @return
     */
    @GetMapping("/findGoodTypeList")
    List<GoodType> findGoodTypeList();

    /**
     * 更新主键自增ID
     */
    @PutMapping("/alterAutoIncrement")
    void alterAutoIncrement();
}
