package com.fang.commonclient.dao;

import com.fang.commonclient.entity.GoodOut;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 接口 {@code GoodOutMapper} 商品出库表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient("data-client")
@RequestMapping("/goodOut")
public interface GoodOutMapper {

    /**
     * 添加出库单
     * @param goodout
     * @return
     */
    @PostMapping("/addNewGoodOut")
    int addNewGoodOut(GoodOut goodout);

    /**
     * 出库单列表
     * @return
     */
    @GetMapping("/findGoodOutList")
    List<GoodOut> findGoodOutList();

    /**
     * 删除出库单一项
     * @param id
     * @return
     */
    @DeleteMapping("/deleteGoodOutById")
    int deleteGoodOutById(Integer id);

    /**
     * 修改出库单信息
     * @param goodOut
     * @return
     */
    @PutMapping("/updateGoodOutById")
    int updateGoodOutById(GoodOut goodOut);

    /**
     * 通过编号查找出库表
     * @param id
     * @return
     */
    @GetMapping("/findGoodOutById")
    GoodOut findGoodOutById(Integer id);

    /**
     * 通过商品名称查询出库单列表
     * @param name
     * @return
     */
    List<GoodOut> findGoodOutListByName(String name);

    /**
     * 通过时间查询出库单列表
     * @param date
     * @return
     */
    List<GoodOut> findGoodOutListByDate(Date date);

    /**
     * 通过营业员员姓名查询出库单列表
     * @param name
     * @return
     */
    List<GoodOut> findGoodOutListByKeeperName(String name);

    /**
     * 更新主键自增ID
     */
    @PutMapping("/alterGoodOutAutoIncrement")
    void alterGoodOutAutoIncrement();
}
