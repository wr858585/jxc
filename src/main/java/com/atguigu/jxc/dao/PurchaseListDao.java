package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.PurchaseList;
import org.apache.ibatis.annotations.Param;

/**
 * @author zqq
 * @create 2021-03-08 15:19
 */
public interface PurchaseListDao {
    Integer savePurchaseList( PurchaseList purchaseList);
}
