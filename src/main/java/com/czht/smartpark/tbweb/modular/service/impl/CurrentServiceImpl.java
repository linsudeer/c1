package com.czht.smartpark.tbweb.modular.service.impl;

import com.czht.smartpark.tbweb.modular.bean.countOnWorkBean;
import com.czht.smartpark.tbweb.modular.constant.OnWorkTypeEnum;
import com.czht.smartpark.tbweb.modular.dmo.TsTodayOnworkCount;
import com.czht.smartpark.tbweb.modular.dto.OnWorkPassDTO;
import com.czht.smartpark.tbweb.modular.dto.OnWrokCntDTO;
import com.czht.smartpark.tbweb.modular.mapper.TsTodayOnworkCountMapper;
import com.czht.smartpark.tbweb.modular.service.CurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrentServiceImpl implements CurrentService {

    @Autowired
    private TsTodayOnworkCountMapper onworkCountMapper;

    @Override
    public List<TsTodayOnworkCount> countOnWorkBy24h(Integer areaId, Integer deptPid, Integer deptId) {
        return onworkCountMapper.countOnworkBy24h(areaId, deptPid, deptId);
    }

    @Override
    public List<OnWrokCntDTO> countOnworkByType(Integer deptId, Integer deptPid) {
        return onworkCountMapper.countOnworkByType(deptId, deptPid);
    }

    @Override
    public List<OnWrokCntDTO> countOnworkByArea(Integer deptId, Integer deptPid) {
        return onworkCountMapper.countOnworkByArea(deptId, deptPid);
    }

    @Override
    public List<OnWrokCntDTO> countOnworkByDept(Integer areaId, Integer deptPid) {
        return onworkCountMapper.countOnworkByDept(areaId, deptPid);
    }

    @Override
    public List<OnWrokCntDTO> countInOutByUserGroup(Integer areaId, Integer deptPid) {
        return null;
    }

    @Override
    public List<OnWorkPassDTO> getOnWorkPassRecords(countOnWorkBean bean) {
        List<OnWorkPassDTO> list = new ArrayList<OnWorkPassDTO>();
        if(bean.getType() == OnWorkTypeEnum.ONWORK.getType()) {// 在岗
            list = onworkCountMapper.getOnWorkPassRecords(bean);
        }else if(bean.getType() == OnWorkTypeEnum.TEMPWORK.getType()){// 临时离岗
            list = onworkCountMapper.getTempWorkPassRecords(bean);
        }else if(bean.getType() == OnWorkTypeEnum.OFFWORK.getType()){// 不在岗
            list = onworkCountMapper.getOffWorkPassRecords(bean);
        }else {
            list = onworkCountMapper.getUsersOnworkPassRecords(bean);
        }
        return list;
    }
}
