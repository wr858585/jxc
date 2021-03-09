package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zllstart
 * @create 2021-03-08-15:07
 */
@RestController
@RequestMapping("/saleListGoods")
public class SaleListGoodsController {

    @Autowired
    private SaleListGoodsService saleListGoodsService;

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
