package com.atguigu.jxc.domain;

import lombok.Data;

/**
 * @author zqq
 * @create 2021-03-08 17:58
 */
@Data
public class PurchaseListQueryVo {
    private String purchaseNumber;
    private Integer supplierId;
    private Integer state;
    private String sTime;
    private String eTime;
}
