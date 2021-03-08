package com.atguigu.jxc.controller;

import com.atguigu.jxc.service.CustomerReturnListGoodsService;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerReturnList")
public class CustomerReturnListGoodsController {
    @Autowired
    private CustomerReturnListGoodsService CustomerReturnListGoodsService;

    @PostMapping("/count")
    public String count(String sTime, String eTime ,Integer goodsTypeId, String codeOrName) {
        return CustomerReturnListGoodsService.count(sTime, eTime,goodsTypeId,codeOrName);
    }
}
