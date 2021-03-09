package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.domain.GetSaleDataByDayVo;
import com.atguigu.jxc.domain.SaleListGoodsVo;
import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.service.SaleListGoodsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {
    @Autowired
    private SaleListGoodsDao saleListGoodsDao;

    @Override
    public String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName) {
        List<SaleListGoodsVo> saleListGoods=saleListGoodsDao.saleListGoods(sTime,eTime,goodsTypeId,codeOrName);

        // 使用谷歌Gson将JSON字符串数组转换成具体的集合
        Gson gson = new Gson();
        String str=gson.toJson(saleListGoods);
        System.out.println(str);
        return str;
    }

    @Override
    public String getSaleDataByDay(String sTime, String eTime) {
        List<GetSaleDataByDayVo> getSaleDataByDayVos=saleListGoodsDao.getSaleDataByDay(sTime,eTime);
        getSaleDataByDayVos.stream().map(getSaleDataByDayVo -> {
            getSaleDataByDayVo.setProfit(getSaleDataByDayVo.getSaleTotal()-getSaleDataByDayVo.getPurchasingTotal());
            return getSaleDataByDayVo;
        }).collect(Collectors.toList());
        Gson gson = new Gson();
        String str=gson.toJson(getSaleDataByDayVos);
        System.out.println(str);
        return str;
    }
}
