package com.fang.commonclient.service.impl;

import com.fang.commonclient.dao.GoodMapper;
import com.fang.commonclient.dao.StockMapper;
import com.fang.commonclient.entity.Good;
import com.fang.commonclient.entity.Stock;
import com.fang.commonclient.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 服务实现 {@code GoodServiceImpl} 商品表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Service
public class GoodServiceImpl implements GoodService {
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
     * @param good
     * @return
     */
    @Override
    public int addNewGood(Good good) {
        Integer id = goodMapper.findMaxId() + 1;
        good.setId(id);
        Stock stock = new Stock();
        stock.setGoodId(good.getId());
        stock.setTypeId(good.getTypeId());
        stock.setUnitId(good.getUnitId());
        stock.setDate(new Date());
        int result=goodMapper.addNewGood(good);
        if (result == 1) {
            stockMapper.addNewStock(stock);
        }
        return result;
    }

    /**
     * 商品列表
     * @return
     */
    @Override
    public List<Good> findGoodList() {
        return goodMapper.findGoodList();
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @Override
    public int deleteGoodById(Integer id) {
        return goodMapper.deleteGoodById(id);
    }

    /**
     * 修改商品
     * @param good
     * @return
     */
    @Override
    public int updateGoodById(Good good) {
        return goodMapper.updateGoodById(good);
    }

    /**
     * 通过名称查找商品
     * @param name
     * @return
     */
    @Override
    public Good findGoodByName(String name) {
        return null;
    }

    /**
     * 通过类型查找商品
     * @param name
     * @return
     */
    @Override
    public List<Good> findGoodListByType(String name) {
        return null;
    }

    /**
     * 主键自增
     */
    @Override
    public void alterGoodAutoIncrement() {
        goodMapper.alterGoodAutoIncrement();
    }
}
