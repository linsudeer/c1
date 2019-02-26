package com.czht.smartpark.tbweb.modular.controller;

import com.czht.smartpark.tbweb.context.tip.ResultTip;
import com.czht.smartpark.tbweb.context.tip.bean.Tip;
import com.czht.smartpark.tbweb.modular.bean.AttendBean;
import com.czht.smartpark.tbweb.modular.dmo.AttendanceRecord;
import com.czht.smartpark.tbweb.modular.dto.AttendStatisticsDTO;
import com.czht.smartpark.tbweb.modular.service.AttendService;
import com.czht.smartpark.tbweb.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attend")
public class AttendController {

    @Autowired
    private AttendService attendService;

    @RequestMapping("/statistics")
    public Tip getStatisticsRecords(AttendBean bean){
        //这里控制时间
        if(DateUtil.getWeek()==1){
            bean.setStartDate(bean.getStartDate()==null?DateUtil.getPreMonday():bean.getStartDate());
            bean.setEndDate(bean.getEndDate()==null?DateUtil.getPreSunday():bean.getEndDate());
        }else {
            bean.setStartDate(bean.getStartDate()==null?DateUtil.getMonday():bean.getStartDate());
            bean.setEndDate(bean.getEndDate()==null?DateUtil.getSunday():bean.getEndDate());
        }
        List<AttendStatisticsDTO> list = attendService.getAttendStatisticsRecords(bean);
        return ResultTip.success(list);
    }

    /**
     * 历史考勤
     * @param bean
     * @return
     */
    @RequestMapping("/history")
    public Tip getHistoryRecords(AttendBean bean) {
        List<AttendanceRecord> list = null;
        Integer count = attendService.countHistoryRecords(bean);
        if(count!= null && count>0){
            list = attendService.getHistoryRecords(bean);
            return ResultTip.success(list, count);
        }

        return ResultTip.success(list);
    }

    /**
     * 修改考勤异常记录
     * @param id 异常id
     * @param remark 原因
     * @return
     */
    @RequestMapping(value = "/updateAttendCausa", method = RequestMethod.POST)
    public Tip updateAttendCausa(Integer id, String remark) {
        attendService.updateAttendCausa(id, remark);
        return ResultTip.success();
    }

    @RequestMapping(value = "modifyStatus", method = RequestMethod.POST)
    public Tip updateAttendStatus(Integer attendId, String status) {
        AttendanceRecord record = attendService.updateAttendStatus(attendId, status);
        return ResultTip.success(record);
    }

}
