package com.atguigu.jxc.domain;

import lombok.Data;

@Data
public class GetSaleDataByDayVo {
    private double saleTotal;
    private String date;
    private double purchasingTotal;
    private double profit;
}
