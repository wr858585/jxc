package com.atguigu.jxc.dao;

import com.atguigu.jxc.domain.SaleListGoodsVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerReturnListGoodsDao {
    List<SaleListGoodsVo> count(String sTime, String eTime, Integer goodsTypeId, String codeOrName);
}
