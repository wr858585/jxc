package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.ReturnList;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface ReturnListService {

    /**
     * 保存退货单
     * @param returnList
     * @return
     */
    Integer saveReturnList(ReturnList returnList);

    /**
     *
     * @param returnNumber
     * @param supplierId
     * @param state
     * @param sTime
     * @param eTime
     * @return
     */
    Map<String, Object> queryReturnList(String returnNumber, Integer supplierId, Integer state, String sTime, String eTime);

}
