package com.atguigu.jxc.controller;

import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("saleListGoods")
public class SaleListGoodsController {

    @Autowired
    private SaleListGoodsService saleListGoodsService;

    @PostMapping("list")
    public Map<String, Object> listBy(@RequestParam(value = "saleNumber", required = false) String saleNumber,
                                      @RequestParam(value = "customerId", required = false) Integer customerId,
                                      @RequestParam(value = "state", required = false) Integer state,
                                      @RequestParam(value = "sTime", required = false) String sTime,
                                      @RequestParam(value = "eTime", required = false) String eTime) {

        return saleListGoodsService.listBy(saleNumber,customerId,state,sTime,eTime);

    }
}
