package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.entity.ReturnListGoods;

import java.util.List;
import java.util.Map;

public interface ReturnListGoodsDao {

    Integer saveReturnListGoods(ReturnListGoods returnListGoodsStr);

    List<Map<String, Object>> queryReturnGoodsList(Integer returnListId);
}
