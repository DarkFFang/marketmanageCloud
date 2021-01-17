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
    @Autowired
    private StockMapper stockMapper;

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
        stockMapper.updateStockQuantityDecByGoodId(goodOut.getGoodId(), goodOut.getQuantity());
        goodOut.setDate(new Date());
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
        /**
         * 删除商品出库表项,同步库存表
         */
        GoodOut goodOut = goodOutMapper.findGoodOutById(id);
        int result = goodOutMapper.deleteGoodOutById(id);
        if (result == 1) {
            stockMapper.updateStockQuantityIncByGoodId(goodOut.getGoodId(), goodOut.getQuantity());
            goodOutMapper.alterGoodOutAutoIncrement();
        }
        return result;
    }

    /**
     * 修改商品出库表项
     *
     * @param goodOut
     * @return
     */
    @PutMapping("/updateGoodOutById")
    public int updateGoodOutById(GoodOut goodOut) {
        /**
         * 修改商品出库表项,同步库存表
         */
        log.warn(goodOut.toString());
        Integer oldQuantity = goodOutMapper.findGoodOutById(goodOut.getId()).getQuantity();
        int result = goodOutMapper.updateGoodOutById(goodOut);
        if (result == 1) {
            GoodOut newGoodOut = goodOutMapper.findGoodOutById(goodOut.getId());
            stockMapper.updateStockQuantityDecByGoodId(newGoodOut.getGoodId(), newGoodOut.getQuantity() - oldQuantity);
        }
        return result;
    }

    /**
     * 通过商品名称查找商品出库表项
     *
     * @param name
     * @return
     */
    public List<GoodOut> findGoodOutListByName(String name) {
        return null;
    }

    /**
     * 通过时间查找商品出库表项
     *
     * @param date
     * @return
     */
    public List<GoodOut> findGoodOutListByDate(Date date) {
        return null;
    }

    /**
     * 通过营业员名称查询商品出库表
     *
     * @param name
     * @return
     */
    public List<GoodOut> findGoodOutListByKeeperName(String name) {
        return null;
    }
}
