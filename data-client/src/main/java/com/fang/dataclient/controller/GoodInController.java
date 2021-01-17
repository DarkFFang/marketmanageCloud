package com.fang.dataclient.controller;


import com.fang.dataclient.dao.GoodInMapper;
import com.fang.dataclient.dao.StockMapper;
import com.fang.dataclient.entity.GoodIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 服务实现 {@code GoodInServiceImpl} 商品入库表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Slf4j
@RestController
@RequestMapping("/goodIn")
public class GoodInController {
    /**
     * 实例GoodInMapper
     */
    @Autowired
    private GoodInMapper goodInMapper;

    /**
     * 添加新的入库表
     *
     * @param goodIn
     * @return int
     */
    @PostMapping("/addNewGoodIn")
    public int addNewGoodIn(GoodIn goodIn) {
        return goodInMapper.addNewGoodIn(goodIn);
    }

    /**
     * 商品入库列表
     *
     * @return {@link List<GoodIn>}
     */
    @GetMapping("/findGoodInList")
    public List<GoodIn> findGoodInList() {
        /**
         * 调用列表方法
         */
        return goodInMapper.findGoodInList();
    }

    /**
     * 删除商品表项
     *
     * @param id id
     * @return int
     */
    @DeleteMapping("/goodin/{id}")
    public int deleteGoodInById(@PathVariable Integer id) {
        return goodInMapper.deleteGoodInById(id);
    }

    /**
     * 修改入库表项
     *
     * @param goodIn
     * @return
     */
    @PutMapping("/goodin")
    public int updateGoodInById(GoodIn goodIn) {
        return goodInMapper.updateGoodInById(goodIn);
    }

    @GetMapping("/findGoodInById")
    GoodIn findGoodInById(Integer id) {
        return goodInMapper.findGoodInById(id);
    }

    /**
     * 通过商品名称查找入库表
     *
     * @param name
     * @return
     */
    @GetMapping("/findGoodInListByName")
    public List<GoodIn> findGoodInListByName(String name) {
        return goodInMapper.findGoodInListByName(name);
    }

    @GetMapping("/findGoodInListByDate")
    public List<GoodIn> findGoodInListByDate(Date date) {
        return goodInMapper.findGoodInListByDate(date);
    }

    @GetMapping("/findGoodInListByClerkName")
    public List<GoodIn> findGoodInListByClerkName(String name) {
        return goodInMapper.findGoodInListByClerkName(name);
    }


    @PutMapping("/alterGoodInAutoIncrement")
    public void alterGoodInAutoIncrement(){
        goodInMapper.alterGoodInAutoIncrement();
    }
}
