package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.PurchaseList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zllstart
 * @create 2021-03-08-15:49
 */
public interface PurchaseListGoodsDao {

    List<PurchaseList> list(
            @Param("purchaseNumber") String purchaseNumber,
            @Param("supplierId") Integer supplierId,
            @Param("state") Integer state,
            @Param("sTime") String sTime,
            @Param("eTime") String eTime
    );
}