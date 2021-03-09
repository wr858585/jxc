package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.ReturnListDao;
import com.atguigu.jxc.domain.ErrorCode;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.service.ReturnListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReturnListServiceImpl implements ReturnListService {

    @Autowired
    private ReturnListDao returnListDao;

    @Override
    public Integer saveReturnList(ReturnList returnList) {
        return returnListDao.saveReturnList(returnList);
    }

    @Override
    public Map<String, Object> queryReturnList(String returnNumber, Integer supplierId, Integer state, String sTime, String eTime) {
        HashMap<String, Object> map = new HashMap<>();
        List<Map<String, Object>> returnLists = returnListDao.queryReturnList(returnNumber,supplierId,state,sTime,eTime);
        map.put("rows",returnLists);
        return map;
    }

    @Override
    public ServiceVO deleteReturnList(Integer returnListId) {
        Integer integer = returnListDao.deleteReturnList(returnListId);
        if(integer == 1){
            return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
        }
        return new ServiceVO<>(ErrorCode.HAS_FORM_ERROR_CODE, ErrorCode.HAS_FORM_ERROR_MESS);
    }

}
