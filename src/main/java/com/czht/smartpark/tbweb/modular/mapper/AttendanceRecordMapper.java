package com.czht.smartpark.tbweb.modular.mapper;

import com.czht.smartpark.tbweb.modular.bean.AttendBean;
import com.czht.smartpark.tbweb.modular.dmo.AttendanceRecord;
import com.czht.smartpark.tbweb.modular.dto.AttendStatisticsDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AttendanceRecordMapper extends Mapper<AttendanceRecord> {

    /**
     * 综合考勤
     * @param bean
     * @return
     */
    List<AttendStatisticsDTO> getAttendStatisticsRecords(AttendBean bean);

    /**
     * 历史考勤
     * @param bean
     * @return
     */
    Integer countHistoryRecords(AttendBean bean);

    /**
     * 历史考勤
     * @param bean
     * @return
     */
    List<AttendanceRecord> getHistoryRecords(AttendBean bean);
}