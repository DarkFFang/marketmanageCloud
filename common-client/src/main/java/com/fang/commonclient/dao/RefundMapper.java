package com.fang.commonclient.dao;

import com.fang.commonclient.entity.Refund;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 接口 {@code RefundMapper} 退货表.
 *
 * @author fang
 * @since 2020/12/14
 */
@FeignClient(value = "data-client",contextId = "Refund")
public interface RefundMapper {

    /**
     * 增加退货表项
     * @param refund
     * @return
     */
    @PostMapping("/refund/addNewRefund")
    int addNewRefund(Refund refund);

    /**
     * 退货列表
     * @return
     */
    @GetMapping("/refund/findRefundList")
    List<Refund> findRefundList();

    /**
     * 删除退货表项
     * @param id
     * @return
     */
    @DeleteMapping("/refund/deleteRefundById")
    int deleteRefundById(Integer id);

    /**
     * 修改退货表项
     * @param refund
     * @return
     */
    @PutMapping("/refund/updateRefundById")
    int updateRefundById(Refund refund);

    /**
     * 通过商品名称查询退货列表
     * @param name
     * @return
     */
//    List<Refund> findRefundListByName(String name);

    /**
     * 通过退货时间查询退货列表
     * @param date
     * @return
     */
//    List<Refund> findRefundListByDate(Date date);
}
