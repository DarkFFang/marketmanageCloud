package com.fang.commonclient.dao;

import com.fang.commonclient.entity.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口 {@code Stock} 库存表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient("data-client")
@RequestMapping("/stock")
public interface StockMapper {

    /**
     * 库存列表
     * @return
     */
    @GetMapping("/findStockList")
    List<Stock> findStockList();

    /**
     * 增加库存
     * @param stock
     * @return
     */
    @PostMapping("/addNewStock")
    int addNewStock(Stock stock);

    /**
     * 删除库存
     * @param id
     * @return
     */
    @DeleteMapping("/deleteStockById")
    int deleteStockById(Integer id);

    /**
     * 修改库存增加数量
     * @param goodid
     * @param increment
     * @return
     */
    @PutMapping("/updateStockQuantityIncByGoodId")
    int updateStockQuantityIncByGoodId(Integer goodid, Integer increment);

    /**
     * 修改库存减少数量
     * @param goodid
     * @param decrement
     * @return
     */
    @PutMapping("/updateStockQuantityDecByGoodId")
    int updateStockQuantityDecByGoodId(Integer goodid, Integer decrement);

    /**
     * 更新库存表商品数量
     * @param goodid
     * @param newQuantity
     * @return
     */
    @PutMapping("/updateStockQuantityByGoodId")
    int updateStockQuantityByGoodId(Integer goodid, Integer newQuantity);

    /**
     * 库存计数
     * @return
     */
    int findStockCount();

    /**
     * 通过商品名称查询该商品库存
     * @param name
     * @return
     */
    Stock findStockByName(String name);

    /**
     * 通过类型查询该类型商品的库存
     * @param name
     * @return
     */
    List<Stock> finStockListByType(String name);


}
