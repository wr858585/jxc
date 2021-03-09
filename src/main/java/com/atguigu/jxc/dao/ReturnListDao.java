package com.atguigu.jxc.dao;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.entity.ReturnList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ReturnListDao {

    Integer saveReturnList(ReturnList returnList);

    List<Map<String, Object>> queryReturnList(@Param("returnNumber") String returnNumber,
                                              @Param("supplierId") Integer supplierId,
                                              @Param("state") Integer state,
                                              @Param("sTime") String sTime,
                                              @Param("eTime") String eTime);

    Integer deleteReturnList(Integer returnListId);
}
