package com.czht.smartpark.tbweb.modular.mapper;

import com.czht.smartpark.tbweb.modular.bean.AttendBean;
import com.czht.smartpark.tbweb.modular.dmo.AttendanceRecord;
import com.czht.smartpark.tbweb.modular.dto.AttendStatisticsDTO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
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

    /**
     * 查找考勤
     * @param attendDate 考勤日期
     * @param userId 用户id
     * @return
     */
    List<AttendanceRecord> getAttend(@Param("attendDate") String attendDate, @Param("userId") Long userId);

    /**
     * 生成考勤 调用存储过程
     * @param attendDate
     * @param userId
     */
    void generalAttend(@Param("attendDate") String attendDate, @Param("userId") Long userId);
}