package com.fang.dataclient.controller;

import com.fang.dataclient.dao.GoodTypeMapper;
import com.fang.dataclient.entity.GoodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品类型服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
@RequestMapping("/goodType")
public class GoodTypeController {
    /**
     * 商品类型映射器
     */
    @Autowired
    private GoodTypeMapper goodTypeMapper;

    /**
     * 添加新的商品类型
     *
     * @param goodType 商品类型
     * @return int
     */
    @PostMapping("/addNewGoodType")
    public int addNewGoodType(@RequestBody GoodType goodType) {
        return goodTypeMapper.addNewGoodType(goodType);
    }

    /**
     * 商品列表
     *
     * @return {@link List<GoodType>}
     */
    @GetMapping("/findGoodTypeList")
    public List<GoodType> findGoodTypeList() {
        return goodTypeMapper.findGoodTypeList();
    }

    @PutMapping("/alterAutoIncrement")
    public void alterAutoIncrement(){
        goodTypeMapper.alterAutoIncrement();
    }

}
