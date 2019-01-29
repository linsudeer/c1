package com.czht.smartpark.tbweb.modular.controller;

import com.czht.smartpark.tbweb.context.aop.annotation.Permission;
import com.czht.smartpark.tbweb.context.tip.ResultTip;
import com.czht.smartpark.tbweb.context.tip.bean.Tip;
import com.czht.smartpark.tbweb.modular.bean.countOnWorkBean;
import com.czht.smartpark.tbweb.modular.constant.Constant;
import com.czht.smartpark.tbweb.modular.dmo.TsTodayOnworkCount;
import com.czht.smartpark.tbweb.modular.dto.OnWorkPassDTO;
import com.czht.smartpark.tbweb.modular.dto.OnWrokCntDTO;
import com.czht.smartpark.tbweb.modular.service.CurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 获取当天的实时数据
 */
@RestController
@RequestMapping("/current")
public class CurrentController extends BaseController{

    @Autowired
    private CurrentService currentService;

    /**
     * 获取实时在岗人数
     * @return
     */
    @RequestMapping(value = "/onwork/24h", method = RequestMethod.GET)
    public Tip countOnWorkBy24h(countOnWorkBean bean) {
        List<TsTodayOnworkCount> passCount = currentService.countOnWorkBy24h(bean.getAreaId(), bean.getDeptPid(), bean.getDeptId());
        return ResultTip.success(passCount);
    }

    /**
     * 统计在岗人员根据在岗类型， 在岗人员，不在岗人员，临时离岗人员
     * @param bean
     * @return
     */
    @Permission(Constant.ROLE_GENERAL)
    @RequestMapping("/count/typeGroup")
    public Tip countOnworkByType(countOnWorkBean bean){
        List<OnWrokCntDTO> data = currentService.countOnworkByType(bean.getDeptId(), bean.getDeptPid());
        return ResultTip.success(data);
    }

    /**
     * 不同区域在岗情况
     * @param bean
     * @return
     */
    @RequestMapping("/count/areaGroup")
    public Tip countOnworkByArea(countOnWorkBean bean){
        List<OnWrokCntDTO> data = currentService.countOnworkByArea(bean.getDeptId(), bean.getDeptPid());
        return ResultTip.success(data);
    }

    /**
     * 某个区域 不同部门在岗情况
     * @param bean
     * @return
     */
    @RequestMapping("/count/deptGroup")
    public Tip countOnworkByDept(countOnWorkBean bean){
        List<OnWrokCntDTO> data = currentService.countOnworkByDept(bean.getAreaId(), bean.getDeptPid());
        return ResultTip.success();
    }

    /**
     * 人员分组不同，进出次数
     * @param bean
     * @return
     */
    @RequestMapping("/count/userGroup")
    public Tip countInOutByUserGroup(countOnWorkBean bean){
        List<OnWrokCntDTO> data = currentService.countInOutByUserGroup(bean.getAreaId(), bean.getDeptPid());
        return ResultTip.success();
    }

    @RequestMapping("/pass")
    public Tip getOnWorkPassRecords(countOnWorkBean bean) {
        List<OnWorkPassDTO> list = currentService.getOnWorkPassRecords(bean);
        return ResultTip.success(list);
    }

}
