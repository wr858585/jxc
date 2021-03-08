package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zllstart
 * @create 2021-03-08-14:41
 */
@Controller
@RequestMapping("/purchaseListGoods")
public class PurchaseListGoodsController {

    @Autowired
    private PurchaseListGoodsService purchaseListGoodsService;

    /**
     * 支付结算（修改进货单付款状态）
     * @param purchaseListId
     * @return
     */
    @ResponseBody
    @PostMapping("/updateState")
    public ServiceVO updateState(Integer purchaseListId) {

        return new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS,null);
    }

    /**
     * 进货统计（可根据 商品类别、商品编码或名称 条件查询）
     * @param sTime
     * @param eTime
     * @param goodsTypeId
     * @param codeOrName
     * @return
     */
    @PostMapping("/count")
    public String count(
            @RequestParam("sTime")String sTime,
            @RequestParam("eTime")String eTime,
            @RequestParam("goodsTypeId")Integer goodsTypeId,
            @RequestParam("codeOrName")String codeOrName
    ){
        String data = this.purchaseListGoodsService.count(sTime, eTime, goodsTypeId, codeOrName);
        return data;
    }

    /**
     * 进货单列表展示（可条件查询：单据号模糊、供应商、是否付款和日期区间）
     * @param purchaseNumber
     * @param supplierId
     * @param state
     * @param sTime
     * @param eTime
     * @return
     */
    @PostMapping("/list")
    @ResponseBody
    public Map<String,Object> list(String purchaseNumber, Integer supplierId, Integer state, String sTime, String eTime) {
        Map<String,Object> map = this.purchaseListGoodsService.list(purchaseNumber,supplierId,state,sTime,eTime);
        return map;
    }

}
