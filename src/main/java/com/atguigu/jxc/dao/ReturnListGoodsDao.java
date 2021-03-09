package com.atguigu.jxc.dao;

import com.atguigu.jxc.domain.PurchaseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zllstart
 * @create 2021-03-09-9:38
 */
public interface ReturnListGoodsDao {
    List<PurchaseVo> count(@Param("sTime") String sTime, @Param("eTime") String eTime, @Param("goodsTypeId") Integer goodsTypeId, @Param("codeOrName") String codeOrName);
}
