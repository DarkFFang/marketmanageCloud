package com.fang.commonclient.dao;

import com.fang.commonclient.entity.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口 {@code Stock} 库存表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient(value = "data-client",contextId = "Stock")
public interface StockMapper {

    /**
     * 库存列表
     * @return
     */
    @GetMapping("/stock/findStockList")
    List<Stock> findStockList();

    /**
     * 增加库存
     * @param stock
     * @return
     */
    @PostMapping("/stock/addNewStock")
    int addNewStock(Stock stock);

    /**
     * 删除库存
     * @param id
     * @return
     */
    @DeleteMapping("/stock/deleteStockById")
    int deleteStockById(Integer id);

    /**
     * 修改库存增加数量
     * @param goodid
     * @param increment
     * @return
     */
    @PutMapping("/stock/updateStockQuantityIncByGoodId")
    int updateStockQuantityIncByGoodId(@RequestParam Integer goodid,@RequestParam  Integer increment);

    /**
     * 修改库存减少数量
     * @param goodid
     * @param decrement
     * @return
     */
    @PutMapping("/stock/updateStockQuantityDecByGoodId")
    int updateStockQuantityDecByGoodId(@RequestParam Integer goodid,@RequestParam  Integer decrement);

    /**
     * 更新库存表商品数量
     * @param goodid
     * @param newQuantity
     * @return
     */
    @PutMapping("/stock/updateStockQuantityByGoodId")
    int updateStockQuantityByGoodId(@RequestParam Integer goodid,@RequestParam  Integer newQuantity);

    /**
     * 库存计数
     * @return
     */
//    int findStockCount();

    /**
     * 通过商品名称查询该商品库存
     * @param name
     * @return
     */
//    Stock findStockByName(String name);

    /**
     * 通过类型查询该类型商品的库存
     * @param name
     * @return
     */
//    List<Stock> finStockListByType(String name);


}
