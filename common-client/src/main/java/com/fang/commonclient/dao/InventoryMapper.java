package com.fang.commonclient.dao;

import com.fang.commonclient.entity.Inventory;
import com.fang.commonclient.entity.InventoryRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * 接口 {@code InventoryMapper} 商品盘存表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient(value = "data-client",contextId = "Inventory")
public interface InventoryMapper {

    /**
     * 增加盘存表
     * @param inventory
     * @return
     */
    @PostMapping("/inventory/addNewInventory")
    int addNewInventory(Inventory inventory);

    /**
     * 删除盘存表
     * @param id
     * @return
     */
//    int deleteInventoryById(Integer id);

    /**
     * 删除所有盘存表
     * @return
     */
    @DeleteMapping("/inventory/deleteInventoryByDate")
    int deleteInventoryByDate(Date date);

    /**
     * 盘存列表
     * @return
     */
//    List<Inventory> findInventoryList();

    /**
     * 修改盘存表(仅修改实际数量)
     * @param inventory
     * @return
     */
//    int updateInventoryListById(Inventory inventory);

    /**
     * 通过时间查询盘存表
     * @param date
     * @return
     */
    @GetMapping("/inventory/findInventoryListByDate")
    List<Inventory> findInventoryListByDate(Date date);

    /**
     * 增加盘存目录
     * @param inventoryRecord
     * @return
     */
    @PostMapping("/inventory/addNewInventoryRecord")
    int addNewInventoryRecord(InventoryRecord inventoryRecord);

    /**
     * 盘存目录列表
     * @return
     */
    @GetMapping("/inventory/findInventoryRecordList")
    List<InventoryRecord> findInventoryRecordList();

    /**
     * 通过id查询盘存目录
     * @param id
     * @return
     */
    @GetMapping("/inventory/findInventoryRecordById")
    InventoryRecord findInventoryRecordById(Integer id);

    @DeleteMapping("/inventory/deleteInventoryRecordById")
    int deleteInventoryRecordById(Integer id);

}
