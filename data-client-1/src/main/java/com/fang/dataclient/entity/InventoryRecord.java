package com.fang.dataclient.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 类 {@code InventoryRecord} 商品盘存记录表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Getter
@Setter
@ToString
public class InventoryRecord {
    /**
     * 商品盘存记录编号
     */
    private Integer id;
    /**
     * 盘存时间
     */
    private Date date;
}
