package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.ReturnList;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReturnListService {

    /**
     * 保存退货单
     * @param returnList
     * @return
     */
    Integer saveReturnList(ReturnList returnList);

}
