package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.service.ReturnListGoodsService;
import com.atguigu.jxc.service.ReturnListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.atguigu.jxc.service.ReturnListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/returnListGoods")
public class ReturnListGoodsController {

    @Resource
    private ReturnListService returnListService;

    @Resource
    private ReturnListGoodsService returnListGoodsService;


    @PostMapping("delete")
    public ServiceVO deleteReturnList(Integer returnListId){
        return returnListService.deleteReturnList(returnListId);
    }

    @PostMapping("goodsList")
    public Map<String, Object> queryReturnGoodsList(Integer returnListId){
        Map<String, Object> returnGoodsList =returnListGoodsService.queryReturnGoodsList(returnListId);
        return returnGoodsList;
    }

    @PostMapping("list")
    public Map<String, Object> queryReturnList(String returnNumber,Integer supplierId, Integer state,String sTime,String eTime){
        Map<String, Object> returnList = returnListService.queryReturnList(returnNumber, supplierId, state, sTime, eTime);
        return returnList;
    }

    @PostMapping("save")
    public ServiceVO save(ReturnList returnList,
                          String returnListGoodsStr){
        //保存退货单
        returnListService.saveReturnList(returnList);
        //保存退货单商品
        return returnListGoodsService.saveReturnListGoods(returnList.getReturnListId(), returnListGoodsStr);
    }


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
