package com.atguigu.jxc.dao;

import com.atguigu.jxc.domain.GetSaleDataByDayVo;
import com.atguigu.jxc.domain.SaleListGoodsVo;
import com.atguigu.jxc.entity.SaleListGoods;
import org.springframework.stereotype.Repository;
import com.atguigu.jxc.entity.SaleList;
import org.apache.ibatis.annotations.Param;
import com.atguigu.jxc.entity.SaleListGoods;
import java.util.List;
import java.util.Map;
import java.util.List;

@Repository
public interface SaleListGoodsDao {

    List<SaleListGoodsVo> saleListGoods(String sTime, String eTime, Integer goodsTypeId, String codeOrName);

    List<GetSaleDataByDayVo> getSaleDataByDay(String sTime, String eTime);

    List<GetSaleDataByDayVo> getSaleDataByMonth(String sTime, String eTime);

    List<Map<String, Object>> listBy(@Param("saleNumber") String saleNumber, @Param("customerId") Integer customerId, @Param("state") Integer state, @Param("sTime") String sTime, @Param("eTime") String eTime);

    List<Map<String, Object>> showDetails(Integer saleListId);

    Boolean deleteBySid(Integer saleListId);

    Boolean deleteBySidOnSaleListGoods(Integer saleListId);

    Integer saveSaleList(SaleList saleList);

    Integer saveSaleListGoods(SaleListGoods saleListGoods);

    void updateState(@Param(" ") Integer saleListId);
}
