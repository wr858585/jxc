package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.entity.ReturnListGoods;
import com.atguigu.jxc.domain.PurchaseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.List;
import java.util.Map;

public interface ReturnListGoodsDao {

    Integer saveReturnListGoods(ReturnListGoods returnListGoodsStr);

    List<Map<String, Object>> queryReturnGoodsList(Integer returnListId);


    List<PurchaseVo> count(@Param("sTime") String sTime, @Param("eTime") String eTime, @Param("goodsTypeId") Integer goodsTypeId, @Param("codeOrName") String codeOrName);
}
