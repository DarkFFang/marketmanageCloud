package com.fang.commonclient.dao;

import com.fang.commonclient.entity.Good;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口 {@code GoodMapper} 商品表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient("data-client")
@RequestMapping("/good")
public interface GoodMapper {

    /**
     * 增加商品
     * @param good
     * @return
     */
    @PostMapping("/addNewGood")
    int addNewGood(Good good);

    /**
     * 商品列表
     * @return
     */
    @GetMapping("/findGoodList")
    List<Good> findGoodList();

    /**
     * 删除商品
     * @param id
     * @return
     */
    @DeleteMapping("/deleteGoodById")
    int deleteGoodById(Integer id);

    /**
     * 修改商品
     * @param good
     * @return
     */
    @PutMapping("/updateGoodById")
    int updateGoodById(Good good);

    /**
     * 查找最大的商品编号
     * @return
     */
    @GetMapping("/findMaxId")
    Integer findMaxId();

    /**
     * 通过商品名称查询商品
     * @param name
     * @return
     */
    Good findGoodByName(String name);

    /**
     * 通过商品类型查询商品列表
     * @param name
     * @return
     */
    List<Good> findGoodListByType(String name);

    /**
     * 更新主键自增ID
     */
    void alterGoodAutoIncrement();

}
