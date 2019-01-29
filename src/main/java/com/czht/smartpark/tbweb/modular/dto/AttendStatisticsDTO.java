package com.czht.smartpark.tbweb.modular.dto;

import java.util.Date;
import java.util.List;

/**
 * 综合考勤（根据userId分组统计）
 */
public class AttendStatisticsDTO {

    private Integer userId;

    private String userName;

    private Integer deptId;

    private String deptName;

    private String startDate;

    private String endDate;

    /**
     * 应出勤天数
     */
    private Integer absenceDays;

    /**
     * 应出勤时长
     */
    private Float absenceTime;

    /**
     * 请假天数
     */
    private Integer leaveDays;

    /**
     * 考勤时长
     */
    private Float attendTime;

    /**
     * 加班时长
     */
    private Float overTime;

    /**
     * 异常情况次数（上午迟到，上午早退....）
     */
    private Integer causaTimes;

    /**
     * 异常情况具体时间
     */
    private List<AttendCausaDTO> causaRecords;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getAbsenceDays() {
        return absenceDays;
    }

    public void setAbsenceDays(Integer absenceDays) {
        this.absenceDays = absenceDays;
    }

    public Integer getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(Integer leaveDays) {
        this.leaveDays = leaveDays;
    }

    public Float getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(Float attendTime) {
        this.attendTime = attendTime;
    }

    public Float getOverTime() {
        return overTime;
    }

    public void setOverTime(Float overTime) {
        this.overTime = overTime;
    }

    public Integer getCausaTimes() {
        return causaTimes;
    }

    public void setCausaTimes(Integer causaTimes) {
        this.causaTimes = causaTimes;
    }

    public List<AttendCausaDTO> getCausaRecords() {
        return causaRecords;
    }

    public void setCausaRecords(List<AttendCausaDTO> causaRecords) {
        this.causaRecords = causaRecords;
    }

    public Float getAbsenceTime() {
        return absenceTime;
    }

    public void setAbsenceTime(Float absenceTime) {
        this.absenceTime = absenceTime;
    }
}
