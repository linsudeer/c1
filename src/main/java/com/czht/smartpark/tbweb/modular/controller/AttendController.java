package com.czht.smartpark.tbweb.modular.controller;

import com.czht.smartpark.tbweb.context.tip.ResultTip;
import com.czht.smartpark.tbweb.context.tip.bean.Tip;
import com.czht.smartpark.tbweb.modular.bean.AttendBean;
import com.czht.smartpark.tbweb.modular.dmo.AttendanceRecord;
import com.czht.smartpark.tbweb.modular.dto.AttendStatisticsDTO;
import com.czht.smartpark.tbweb.modular.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attend")
public class AttendController {

    @Autowired
    private AttendService attendService;

    @RequestMapping("/statistics")
    public Tip getStatisticsRecords(AttendBean bean){
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

}