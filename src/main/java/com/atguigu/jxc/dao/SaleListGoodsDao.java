package com.atguigu.jxc.dao;

import com.atguigu.jxc.domain.SaleListGoodsVo;
import com.atguigu.jxc.entity.SaleListGoods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleListGoodsDao {

    List<SaleListGoodsVo> saleListGoods(String sTime, String eTime, Integer goodsTypeId, String codeOrName);
}
