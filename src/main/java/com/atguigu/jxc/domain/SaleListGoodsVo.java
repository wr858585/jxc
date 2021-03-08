package com.atguigu.jxc.domain;

import lombok.Data;
import org.springframework.context.annotation.Bean;
@Data
public class SaleListGoodsVo {
    private String number;
    private String date;
    private String customerName;
    private String code;
    private String name;
    private String model;
    private String goodsType;
    private String unit;
    private double price;
    private Integer num;
    private double total;
}
