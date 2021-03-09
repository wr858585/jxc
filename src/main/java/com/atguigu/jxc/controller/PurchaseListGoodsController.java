package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.PurchaseListQueryVo;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.entity.Supplier;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import com.atguigu.jxc.service.PurchaseListService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
    public ServiceVO save(PurchaseList purchaseList, String purchaseListGoodsStr, HttpSession session) {
        // 保存入库单
        Integer purchaseListId = this.purchaseListService.savePurchaseList(purchaseList,session);
        //保存入库商品
        this.purchaseListGoodsService.savePurchaseListGoods(purchaseListGoodsStr,purchaseListId);
        return null;
    }

    @PostMapping("/list")
    @RequiresPermissions(value = "供应商管理")
    public Map<String,Object> purchaseListListByQueryParam(PurchaseListQueryVo purchaseListQueryVo){
        return this.purchaseListGoodsService.purchaseListListByQueryParam(purchaseListQueryVo);
    }
    @PostMapping("/goodsList")
    @RequiresPermissions(value = "供应商管理")
    public Map<String,Object> queryGoodsByPurchaseListId(Integer  purchaseListId){
        return this.purchaseListGoodsService.queryGoodsByPurchaseListId(purchaseListId);
    }
    @PostMapping("/delete")
    @RequiresPermissions(value = "供应商管理")
    public ServiceVO deletePurchaseListById(Integer  purchaseListId){
        return this.purchaseListGoodsService.deletePurchaseListById(purchaseListId);
    }

}
