package com.fang.commonclient.dao;

import com.fang.commonclient.entity.Supplier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口 {@code SupplierMapper} 供应商表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient(value = "data-client",contextId = "Supplier")
public interface SupplierMapper {

    /**
     * 增加供应商
     * @param supplier
     * @return
     */
    @PostMapping("/supplier/addNewSupplier")
    int addNewSupplier(Supplier supplier);

    /**
     * 供应商列表
     * @return
     */
    @GetMapping("/supplier/findSupplierList")
    List<Supplier> findSupplierList();

    /**
     * 删除供应商
     * @param id
     * @return
     */
    @DeleteMapping("/supplier/deleteSupplierById")
    int deleteSupplierById(Integer id);

    /**
     * 修改供应商
     * @param supplier
     * @return
     */
    @PutMapping("/supplier/updateSupplierById")
    int updateSupplierById(Supplier supplier);

    /**
     * 通过供应商名称查询供应商
     * @param name
     * @return
     */
//    Supplier findSupplierByName(String name);

    /**
     * 通过名誉查询供应商列表
     * @param reputation
     * @return
     */
//    List<Supplier> findSupplierListByReputation(String reputation);
}
