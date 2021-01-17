package com.fang.commonclient.dao;

import com.fang.commonclient.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口 {@code SupplierMapper} 供应商表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient("data-client")
@RequestMapping("/supplier")
public interface SupplierMapper {

    /**
     * 增加供应商
     * @param supplier
     * @return
     */
    @PostMapping("/addNewSupplier")
    int addNewSupplier(Supplier supplier);

    /**
     * 供应商列表
     * @return
     */
    @GetMapping("/findSupplierList")
    List<Supplier> findSupplierList();

    /**
     * 删除供应商
     * @param id
     * @return
     */
    @DeleteMapping("/deleteSupplierById")
    int deleteSupplierById(Integer id);

    /**
     * 修改供应商
     * @param supplier
     * @return
     */
    @PutMapping("/updateSupplierById")
    int updateSupplierById(Supplier supplier);

    /**
     * 通过供应商名称查询供应商
     * @param name
     * @return
     */
    Supplier findSupplierByName(String name);

    /**
     * 通过名誉查询供应商列表
     * @param reputation
     * @return
     */
    List<Supplier> findSupplierListByReputation(String reputation);
}
