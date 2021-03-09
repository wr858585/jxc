package com.atguigu.jxc.entity;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 进货单
 */
@Data
public class PurchaseList {

  private Integer purchaseListId;
  private String purchaseNumber;
  private double amountPaid;
  private double amountPayable;
  private String purchaseDate;
  private String remarks;
  private Integer state;
  private Integer supplierId;
  private Integer userId;

  private String supplierName;
  private String trueName;

}
