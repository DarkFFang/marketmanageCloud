package com.fang.dataclient.controller;


import com.fang.dataclient.dao.StockMapper;
import com.fang.dataclient.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 库存服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    /**
     * 库存映射器
     */
    @Autowired
    private StockMapper stockMapper;

    /**
     * 库存列表
     *
     * @return {@link List<Stock>}
     */
    @GetMapping("/findStockList")
    public List<Stock> findStockList() {
        return stockMapper.findStockList();
    }

    /**
     * 添加新的库存
     *
     * @param stock 股票
     * @return int
     */
    @PostMapping("/addNewStock")
    public int addNewStock(Stock stock) {
        return stockMapper.addNewStock(stock);
    }

    /**
     * 通过id删除库存
     *
     * @param id id
     * @return int
     */
    @DeleteMapping("/deleteStockById")
    public int deleteStockById(Integer id) {
        return stockMapper.deleteStockById(id);
    }

    /**
     * 通过id更新库存
     *
     * @param stock 库存
     * @return int
     */
    public int updateStockById(Stock stock) {
       return 0;
    }

    /**
     * 通过商品名称查询库存
     *
     * @param name 名字
     * @return {@link Stock}
     */
    public Stock findStockByName(String name) {
        return null;
    }

    /**
     * 库存列表类型列表
     *
     * @param name 的名字
     * @return {@link List<Stock>}
     */
    public List<Stock> finStockListByType(String name) {
        return null;
    }

}
