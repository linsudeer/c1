package com.czht.smartpark.tbweb.modular.service.impl;

import com.czht.smartpark.tbweb.context.support.HttpServletRequestHolder;
import com.czht.smartpark.tbweb.modular.bean.AttendBean;
import com.czht.smartpark.tbweb.modular.constant.Constant;
import com.czht.smartpark.tbweb.modular.dmo.AttendanceCausa;
import com.czht.smartpark.tbweb.modular.dmo.AttendanceRecord;
import com.czht.smartpark.tbweb.modular.dto.AttendStatisticsDTO;
import com.czht.smartpark.tbweb.modular.dto.UserDTO;
import com.czht.smartpark.tbweb.modular.mapper.AttendanceCausaMapper;
import com.czht.smartpark.tbweb.modular.mapper.AttendanceRecordMapper;
import com.czht.smartpark.tbweb.modular.service.AttendService;
import com.czht.smartpark.tbweb.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AttendServiceImpl implements AttendService {

    @Autowired
    private AttendanceRecordMapper attendMapper;

    @Autowired
    private AttendanceCausaMapper attendCausalMapper;

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

    @Override
    public void updateAttendCausa(Integer id, String remark) {
        AttendanceCausa causal = attendCausalMapper.selectByPrimaryKey(id);
        if(causal != null){
            causal.setReviewFlag(Constant.ATTEND_CAUSAL_FLAG_YES);
            causal.setReviewRemark(remark);

            UserDTO user = HttpServletRequestHolder.getSessionInfo();
            causal.setReviewUserId(user.getUserId());
            causal.setReviewUserName(user.getUserName());
            causal.setReviewTime(new Date());
            causal.setUpdated(new Date());

            attendCausalMapper.updateByPrimaryKey(causal);

            // 这里增加修改记录到系统日志 TODO
        }
    }

    @Override
    public AttendanceRecord updateAttendStatus(Integer attendId, String status) {
        if(attendId == null) return null;

        String remark = "";
        UserDTO user = HttpServletRequestHolder.getSessionInfo();
        remark = DateUtil.getDate("yyyy-MM-dd HH:mm:ss") + "修改考勤状态为"+status+";";
        attendMapper.updateAttendStatus(attendId, status, remark);

        // 增加操作记录

        return attendMapper.selectByPrimaryKey(attendId);
    }
}
