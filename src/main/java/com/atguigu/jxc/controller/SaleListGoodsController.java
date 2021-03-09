package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.DamageList;
import com.atguigu.jxc.service.GoodsService;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/saleListGoods")
public class SaleListGoodsController {

    @Autowired
    private SaleListGoodsService saleListGoodsService;

    @PostMapping("/count")
    public String count(String sTime, String eTime ,Integer goodsTypeId, String codeOrName) {
        return saleListGoodsService.count(sTime, eTime,goodsTypeId,codeOrName);
    }

    @PostMapping("/getSaleDataByDay")
    public String getSaleDataByDay(String sTime, String eTime ) {
        return saleListGoodsService.getSaleDataByDay(sTime, eTime);
    }

    @PostMapping("/getSaleDataByMonth")
    public String getSaleDataByMonth(String sTime, String eTime ) {
        return saleListGoodsService.getSaleDataByMonth(sTime, eTime);
    }
}
