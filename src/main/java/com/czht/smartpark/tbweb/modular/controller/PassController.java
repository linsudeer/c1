package com.czht.smartpark.tbweb.modular.controller;

import com.czht.smartpark.tbweb.context.tip.ResultTip;
import com.czht.smartpark.tbweb.context.tip.bean.Tip;
import com.czht.smartpark.tbweb.modular.bean.PassBean;
import com.czht.smartpark.tbweb.modular.dmo.PassRecord;
import com.czht.smartpark.tbweb.modular.dto.PassDTO;
import com.czht.smartpark.tbweb.modular.dto.ScreenDTO;
import com.czht.smartpark.tbweb.modular.service.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pass")
public class PassController{

    @Autowired
    private PassService passService;

    @RequestMapping("/list")
    public Tip getPassRecords(HttpServletRequest request, PassBean query) {

        Integer count = passService.getPassCount(query);
        List<PassDTO> records = new ArrayList<PassDTO>();

        if(count != null && count > 0){
            records = passService.getPassRecords(query);
        }

        return ResultTip.success(records, count);
    }

    /**
     * 新增记录
     * @param bean
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Tip addPassRecords(PassBean bean) {
        PassDTO record = passService.addPassRecord(bean);
        return ResultTip.success(record);
    }

    /**
     * 更新记录
     * @param bean
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Tip editPassRecords(PassBean bean) {
        PassDTO record = passService.updatePassRecord(bean);
        return ResultTip.success(record);
    }

    /**
     * 删除记录
     * @param bean
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public Tip deletePassRecords(Long recordId) {
        passService.deletePassRecord(recordId);
        return ResultTip.success();
    }

    @RequestMapping(value="/screenHearBeat", method=RequestMethod.GET)
    public Tip screenHearBeat(Integer areaId) {

        return ResultTip.success(passService.screenHearBeat(areaId));
    }

    @RequestMapping(value="/getScreenData", method=RequestMethod.GET)
    public Tip getScreenData(Long passRecordId, Integer areaId){
        ScreenDTO dto = passService.getScreenData(passRecordId, areaId);
        return ResultTip.success(dto);
    }

}
