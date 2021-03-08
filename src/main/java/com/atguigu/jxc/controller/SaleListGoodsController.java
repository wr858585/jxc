package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saleListGoods")
public class SaleListGoodsController {
    @Autowired
    SaleListGoodsService saleListGoodsService;

    @RequestMapping(value = "/sale", method = RequestMethod.POST)
    public ServiceVO save(SaleList saleList, String saleListGoodsStr) {
        return saleListGoodsService.save(saleList, saleListGoodsStr);
    }
}
