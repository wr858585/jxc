package com.atguigu.jxc.controller;

import com.atguigu.jxc.service.ReturnListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zllstart
 * @create 2021-03-09-9:32
 */
@RestController
@RequestMapping("returnListGoods")
public class ReturnListGoodsController {

    @Autowired
    private ReturnListGoodsService returnListGoodsService;

    /**
     * 退货统计（可根据 商品类别、商品编码或名称 条件查询）
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
        String data = this.returnListGoodsService.count(sTime, eTime, goodsTypeId, codeOrName);
        return data;
    }
}
