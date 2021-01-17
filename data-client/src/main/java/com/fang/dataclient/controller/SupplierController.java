package com.fang.dataclient.controller;


import com.fang.dataclient.dao.SupplierMapper;
import com.fang.dataclient.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 供应商服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {
    /**
     * 供应商映射器
     */
    @Autowired
    private SupplierMapper supplierMapper;

    /**
     * 增加新的供应商
     *
     * @param supplier 供应商
     * @return int
     */
    @PostMapping("/addNewSupplier")
    public int addNewSupplier(Supplier supplier) {
        return supplierMapper.addNewSupplier(supplier);
    }

    /**
     * 供应商列表
     *
     * @return {@link List<Supplier>}
     */
    @GetMapping("/findSupplierList")
    public List<Supplier> findSupplierList() {
        return supplierMapper.findSupplierList();
    }

    /**
     * 通过id删除供应商
     *
     * @param id id
     * @return int
     */
    @DeleteMapping("/deleteSupplierById")
    public int deleteSupplierById(Integer id) {
        return supplierMapper.deleteSupplierById(id);
    }

    /**
     * 通过id更新供应商
     *
     * @param supplier 供应商
     * @return int
     */
    @PutMapping("/updateSupplierById")
    public int updateSupplierById(Supplier supplier) {
        return supplierMapper.updateSupplierById(supplier);
    }

    /**
     * 通过供应商名称查询供应商
     *
     * @param name 名字
     * @return {@link Supplier}
     */
    @GetMapping("/findSupplierByName")
    public Supplier findSupplierByName(String name) {
        return supplierMapper.findSupplierByName(name);
    }

    /**
     * 通过声誉查找供应商
     *
     * @param reputation 声誉
     * @return {@link List<Supplier>}
     */
    @GetMapping("/findSupplierListByReputation")
    public List<Supplier> findSupplierListByReputation(String reputation) {
        return supplierMapper.findSupplierListByReputation(reputation);
    }
}
