package com.czht.smartpark.tbweb.modular.service.impl;

import com.czht.smartpark.tbweb.modular.bean.AttendBean;
import com.czht.smartpark.tbweb.modular.dmo.AttendanceRecord;
import com.czht.smartpark.tbweb.modular.dto.AttendStatisticsDTO;
import com.czht.smartpark.tbweb.modular.mapper.AttendanceRecordMapper;
import com.czht.smartpark.tbweb.modular.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendServiceImpl implements AttendService {

    @Autowired
    private AttendanceRecordMapper attendMapper;

    @Override
    public List<AttendStatisticsDTO> getAttendStatisticsRecords(AttendBean bean) {
        return attendMapper.getAttendStatisticsRecords(bean);
    }

    @Override
    public Integer countHistoryRecords(AttendBean bean) {
        return attendMapper.countHistoryRecords(bean);
    }

    @Override
    public List<AttendanceRecord> getHistoryRecords(AttendBean bean) {
        return attendMapper.getHistoryRecords(bean);
    }
}
