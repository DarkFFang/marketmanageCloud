package com.fang.dataclient.controller;


import com.fang.dataclient.dao.GoodMapper;
import com.fang.dataclient.dao.StockMapper;
import com.fang.dataclient.entity.Good;
import com.fang.dataclient.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 服务实现 {@code GoodServiceImpl} 商品表.
 *
 * @author fang
 * @since 2020/12/14
 */
@RestController
@RequestMapping("/good")
public class GoodController {
    /**
     * 实例GoodMapper
     */
    @Autowired
    private GoodMapper goodMapper;
    /**
     * 实例StockMapper
     */
    @Autowired
    private StockMapper stockMapper;

    /**
     * 增加商品
     *
     * @param good
     * @return
     */
    @PostMapping("/addNewGood")
    public int addNewGood(Good good) {
        Integer id = goodMapper.findMaxId() + 1;
        good.setId(id);
        Stock stock = new Stock();
        stock.setGoodId(good.getId());
        stock.setUnitId(good.getUnitId());
        stock.setDate(new Date());
        int result = goodMapper.addNewGood(good);
        if (result == 1) {
            stockMapper.addNewStock(stock);
        }
        return result;
    }

    /**
     * 商品列表
     *
     * @return
     */
    @GetMapping("/findGoodList")
    public List<Good> findGoodList() {
        return goodMapper.findGoodList();
    }

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteGoodById")
    public int deleteGoodById(Integer id) {
        return goodMapper.deleteGoodById(id);
    }

    /**
     * 修改商品
     *
     * @param good
     * @return
     */
    @PutMapping("/updateGoodById")
    public int updateGoodById(Good good) {
        return goodMapper.updateGoodById(good);
    }

    /**
     * 通过名称查找商品
     *
     * @param name
     * @return
     */
    public Good findGoodByName(String name) {
        return null;
    }

    /**
     * 通过类型查找商品
     *
     * @param name
     * @return
     */
    public List<Good> findGoodListByType(String name) {
        return null;
    }

    /**
     * 主键自增
     */
    public void alterGoodAutoIncrement() {
        goodMapper.alterGoodAutoIncrement();
    }
}
