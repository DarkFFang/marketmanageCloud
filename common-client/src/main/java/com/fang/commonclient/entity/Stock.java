package com.fang.commonclient.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 类 {@code Stock} 库存表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Getter
@Setter
@ToString
public class Stock {
    /**
     * 商品编号
     */
    private Integer goodId;
    /**
     * 更新时间
     */
    private Date date;
    /**
     * 商品数量
     */
    private Integer quantity;
    /**
     * 单位编号
     */
    private Integer unitId;
    /**
     * 种类编号
     */
    private Integer typeId;
    /**
     * 总金额
     */
    private Integer price;
}
