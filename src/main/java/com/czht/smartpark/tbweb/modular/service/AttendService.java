package com.czht.smartpark.tbweb.modular.service;

import com.czht.smartpark.tbweb.modular.bean.AttendBean;
import com.czht.smartpark.tbweb.modular.dmo.AttendanceRecord;
import com.czht.smartpark.tbweb.modular.dto.AttendStatisticsDTO;

import java.util.List;

public interface AttendService {

    /**
     * 综合考勤
     * @param bean
     * @return
     */
    List<AttendStatisticsDTO> getAttendStatisticsRecords(AttendBean bean);

    /**
     * 历史考勤数量
     * @param bean
     * @return
     */
    Integer countHistoryRecords(AttendBean bean);

    /**
     * 历史考勤 列表
     * @param bean
     * @return
     */
    List<AttendanceRecord> getHistoryRecords(AttendBean bean);

    /**
     * 修改考勤异常情况
     * @param id
     * @param remark
     */
    void updateAttendCausa(Integer id, String remark);

    /**
     * 修改考勤状态
     * @param attendId
     * @param status
     */
    AttendanceRecord updateAttendStatus(Integer attendId, String status);
}
