package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.service.ReturnListGoodsService;
import com.atguigu.jxc.service.ReturnListService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/returnListGoods")
public class ReturnListGoodsController {

    @Resource
    private ReturnListService returnListService;

    @Resource
    private ReturnListGoodsService returnListGoodsService;

    @PostMapping("save")
    public ServiceVO save(ReturnList returnList,
                          String returnListGoodsStr){
        //保存退货单
        returnListService.saveReturnList(returnList);
        //保存退货单商品
        return returnListGoodsService.saveReturnListGoods(returnList.getReturnListId(), returnListGoodsStr);
    }

}
