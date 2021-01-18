package com.fang.dataclient.controller;


import com.fang.dataclient.dao.InventoryMapper;
import com.fang.dataclient.dao.StockMapper;
import com.fang.dataclient.entity.Inventory;
import com.fang.dataclient.entity.InventoryRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 盘存服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    /**
     * 盘存映射器
     */
    @Autowired
    private InventoryMapper inventoryMapper;

    @PostMapping("/addNewInventory")
    public int addNewInventory(@RequestBody Inventory inventory) {
        return inventoryMapper.addNewInventory(inventory);
    }


    /**
     * 通过id删除盘存目录
     *
     * @param id id
     * @return int
     */
    @DeleteMapping("/deleteInventoryById")
    public int deleteInventoryById(Integer id) {
        return inventoryMapper.deleteInventoryById(id);
    }

    @DeleteMapping("/deleteInventoryByDate")
    public int deleteInventoryByDate(Date date) {
        return inventoryMapper.deleteInventoryByDate(date);
    }

    /**
     * 盘存列表
     *
     * @return {@link List<Inventory>}
     */
    @GetMapping("/findInventoryList")
    public List<Inventory> findInventoryList() {
        return inventoryMapper.findInventoryList();
    }

    /**
     * 更新盘存
     *
     * @param inventory 库存
     * @return int
     */
    @PutMapping("/updateInventoryListById")
    public int updateInventoryListById(@RequestBody Inventory inventory) {
        return inventoryMapper.updateInventoryListById(inventory);
    }

    /**
     * 按日期查找盘存列表
     *
     * @param date 日期
     * @return {@link List<Inventory>}
     */
    @GetMapping("findInventoryListByDate")
    public List<Inventory> findInventoryListByDate(Date date) {
        return inventoryMapper.findInventoryListByDate(date);
    }

    /**
     * 添加新的盘存记录
     *
     * @return int
     */
    @PostMapping("addNewInventoryRecord")
    public int addNewInventoryRecord(@RequestBody InventoryRecord inventoryRecord) {
        return inventoryMapper.addNewInventoryRecord(inventoryRecord);
    }

    /**
     * 盘存记录列表
     *
     * @return {@link List<InventoryRecord>}
     */
    @GetMapping("/findInventoryRecordList")
    public List<InventoryRecord> findInventoryRecordList() {
        return inventoryMapper.findInventoryRecordList();
    }

    /**
     * 通过id查找盘存记录
     *
     * @param id id
     * @return {@link InventoryRecord}
     */
    @GetMapping("/findInventoryRecordById")
    public InventoryRecord findInventoryRecordById(Integer id) {
        return inventoryMapper.findInventoryRecordById(id);
    }

    @DeleteMapping("/deleteInventoryRecordById")
    public int deleteInventoryRecordById(Integer id) {
        return inventoryMapper.deleteInventoryRecordById(id);
    }
}
