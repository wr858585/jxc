package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.entity.Supplier;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import com.atguigu.jxc.service.PurchaseListService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description 购买订单Controller控制器
 */
@RestController
@RequestMapping("/purchaseListGoods")
public class PurchaseListGoodsController {

    /**
     * 添加进货商品以及进货单
     * @param purchaseList
     * @param purchaseListGoodsStr
     * @return
     */
    @Autowired
    private PurchaseListService purchaseListService;
    @Autowired
    private PurchaseListGoodsService purchaseListGoodsService;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @RequiresPermissions(value = "供应商管理")
    public ServiceVO save(PurchaseList purchaseList,String purchaseListGoodsStr) {
        // 保存入库单
        this.purchaseListService.savePurchaseList(purchaseList);
        //保存入库商品
        this.purchaseListGoodsService.savePurchaseListGoods(purchaseListGoodsStr);
        return null;
    }

}
