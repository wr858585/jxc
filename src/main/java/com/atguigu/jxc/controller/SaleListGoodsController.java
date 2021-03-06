package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.atguigu.jxc.domain.ErrorCode;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/saleListGoods")
public class SaleListGoodsController {
    @Autowired
    SaleListGoodsService saleListGoodsService;

    @RequestMapping("/save")
    @RequiresPermissions(value = "销售出库")
    public ServiceVO save(SaleList saleList, String saleListGoodsStr) {
        return saleListGoodsService.save(saleList, saleListGoodsStr);
    }

    @PostMapping("list")
    @ResponseBody
    public Map<String, Object> listBy(@RequestParam(value = "saleNumber", required = false) String saleNumber,
                                           @RequestParam(value = "customerId", required = false) Integer customerId,
                                           @RequestParam(value = "state", required = false) Integer state,
                                           @RequestParam(value = "sTime") String sTime,
                                           @RequestParam(value = "eTime") String eTime) {

        return saleListGoodsService.listBy(saleNumber,customerId,state,sTime,eTime);

    }

    @PostMapping("goodsList")
    @ResponseBody
    public Map<String,Object> showDetails(@RequestParam("saleListId") Integer saleListId){
        return saleListGoodsService.showDetails(saleListId);
    }

    @PostMapping("delete")
    @ResponseBody
    public ServiceVO deleteBySid(@RequestParam Integer saleListId) {
        //先删除saleListGoods表
        Boolean b1 = saleListGoodsService.deleteBySidOnSaleListGoods(saleListId);
        //再删除saleList表
        Boolean b = saleListGoodsService.deleteBySid(saleListId);

        if (b && b1) {
            return new ServiceVO(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
        } else {
            return new ServiceVO(ErrorCode.HAS_FORM_ERROR_CODE, ErrorCode.HAS_FORM_ERROR_MESS);
        }
    }


    /**
     * 支付结算（修改销售单付款状态）
     * @param saleListId
     * @return
     */
    @PostMapping("/updateState")
    public ServiceVO updateState(Integer saleListId){
        this.saleListGoodsService.updateState(saleListId);
        return new ServiceVO(100, "请求成功", null);
    }
}
