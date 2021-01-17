package com.fang.commonclient.dao;

import com.fang.commonclient.entity.GoodIn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 接口 {@code GoodInMapper} 商品入库表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient("data-client")
@RequestMapping("/goodIn")
public interface GoodInMapper {
    /**
     * 添加入库单
     * @param goodin
     * @return
     */
    @PostMapping("/addNewGoodIn")
    int addNewGoodIn(GoodIn goodin);

    /**
     * 入库单列表
     * @return
     */
    @GetMapping("/findGoodInList")
    List<GoodIn> findGoodInList();

    /**
     * 删除入库表一项
     * @param id
     * @return
     */
    @DeleteMapping("/deleteGoodInById")
    int deleteGoodInById(Integer id);

    /**
     * 修改入库单信息
     * @param goodIn
     * @return
     */
    @PutMapping("/updateGoodInById")
    int updateGoodInById(GoodIn goodIn);

    /**
     * 通过编号查询入库表
     * @param id
     * @return
     */
    @GetMapping("/findGoodInById")
    GoodIn findGoodInById(Integer id);

    /**
     * 通过商品名称查询入库单列表
     * @param name
     * @return
     */
    List<GoodIn> findGoodInListByName(String name);

    /**
     * 通过时间查询入库单列表
     * @param date
     * @return
     */
    List<GoodIn> findGoodInListByDate(Date date);

    /**
     * 通过库管员姓名查询入库单列表
     * @param name
     * @return
     */
    List<GoodIn> findGoodInListByClerkName(String name);

    /**
     * 更新主键自增ID
     */
    @PutMapping("/alterGoodInAutoIncrement")
    void alterGoodInAutoIncrement();
}
