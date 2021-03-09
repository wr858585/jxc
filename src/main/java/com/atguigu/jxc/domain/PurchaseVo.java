package com.atguigu.jxc.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author zllstart
 * @create 2021-03-08-16:03
 */
@Data
public class PurchaseVo {

    private String number;
    private String date;
    private String supplierName;
    private String code;
    private String name;
    private String model;
    private String goodsType;
    private String unit;
    private Double price;
    private Integer num;
    private Double total;
}
