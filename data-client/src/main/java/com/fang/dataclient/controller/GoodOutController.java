package com.fang.dataclient.controller;

import com.fang.dataclient.dao.GoodOutMapper;
import com.fang.dataclient.dao.StockMapper;
import com.fang.dataclient.entity.GoodOut;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 服务实现 {@code GoodOutServiceImpl} 商品出库表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Slf4j
@RestController
@RequestMapping("/goodOut")
public class GoodOutController {
    /**
     * 实例GoodOutMapper
     */
    @Autowired
    private GoodOutMapper goodOutMapper;
    /**
     * 实例StockMapper
     */

    /**
     * 增加商品出库表项
     *
     * @param goodOut
     * @return
     */
    @PostMapping("/addNewGoodOut")
    public int addNewGoodOut(GoodOut goodOut) {
        /**
         * 增加商品出库表项,同步库存表
         */
        return goodOutMapper.addNewGoodOut(goodOut);
    }

    /**
     * 商品出库列表
     *
     * @return
     */
    @GetMapping("/findGoodOutList")
    public List<GoodOut> findGoodOutList() {
        /**
         * 调用出库列表方法
         */
        return goodOutMapper.findGoodOutList();
    }

    /**
     * 删除商品出库表项
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteGoodOutById")
    public int deleteGoodOutById(Integer id) {
        return goodOutMapper.deleteGoodOutById(id);
    }

    /**
     * 修改商品出库表项
     *
     * @param goodOut
     * @return
     */
    @PutMapping("/updateGoodOutById")
    public int updateGoodOutById(GoodOut goodOut) {
        return goodOutMapper.updateGoodOutById(goodOut);
    }

    @GetMapping("/findGoodOutById")
    public GoodOut findGoodOutById(Integer id) {
        return goodOutMapper.findGoodOutById(id);
    }

    /**
     * 通过商品名称查找商品出库表项
     *
     * @param name
     * @return
     */
    @GetMapping("/findGoodOutListByName")
    public List<GoodOut> findGoodOutListByName(String name) {
        return goodOutMapper.findGoodOutListByName(name);
    }

    /**
     * 通过时间查找商品出库表项
     *
     * @param date
     * @return
     */
    @GetMapping("/findGoodOutListByDate")
    public List<GoodOut> findGoodOutListByDate(Date date) {
        return goodOutMapper.findGoodOutListByDate(date);
    }

    /**
     * 通过营业员名称查询商品出库表
     *
     * @param name
     * @return
     */

    @GetMapping("/findGoodOutListByKeeperName")
    public List<GoodOut> findGoodOutListByKeeperName(String name) {
        return goodOutMapper.findGoodOutListByKeeperName(name);
    }

    @PutMapping("/alterGoodOutAutoIncrement")
    public void alterGoodOutAutoIncrement() {
        goodOutMapper.alterGoodOutAutoIncrement();
    }

}
