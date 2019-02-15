package com.czht.smartpark.tbweb.modular.dto;

import com.czht.smartpark.tbweb.modular.dmo.AttendanceCausa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class AttendDTO {

    private Integer id;

    private Integer userId;

    private String userName;

    private Integer deptPid;

    private Integer deptId;

    private String deptName;

    /**
     * 考勤日期
     */
    private Date attendDate;

    /**
     * 迟到超过多少分钟算迟到
     */
    private Long lateMinUnit;

    /**
     * 加班超过多少分钟算迟到
     */
    private Long overMinUnit;

    /**
     * 考勤规则ID（FK），规则的类型是创建不可更改，所以不需要存考勤类型
     */
    private Byte attendRuleId;

    /**
     * 上午签到打卡时间：设备方向为进的时间点中最小的
     */
    private String signInTimeAm;

    /**
     * 上午签退打卡时间：设备方向为出的时间点中最大的
     */
    private String signOutTimeAm;

    /**
     * 下午签到打卡时间：设备方向为进的时间点中最小的
     */
    private String signInTimePm;

    /**
     * 下午签退打卡时间：设备方向为出的时间点中最大的
     */
    private String signOutTimePm;

    private String week;

    /**
     * 是否修正（0：未修正；1：已修正）
     */
    private Integer reviewFlag;

    /**
     * 如果修正过，修正的原因
     */
    private String reviewRemark;

    /**
     * 应出勤时长，如果有临时外出，请假等情况，应出勤时长会减小
     */
    private Float absenceTime;

    /**
     * 实际出勤时长
     */
    private Float actualTime;

    /**
     * 加班时长，这里是在加班点计算的加班时长
     */
    private Float overTime;

    /**
     * 请假标识默认0-正常上班  1-请假 2-节假日 3-大队执勤等不属于请假的范畴
     */
    private Integer leaveStatus;

    /**
     * 请假描述，出差，还是事假,还是什么节假日
     */
    private String leaveRemark;

    /**
     * 计算详情，考勤是怎么计算出来的，例如（上午出勤多久，下午出勤多久，是否临时离岗，以及临时离岗时间等）
     */
    private String computeDetail;

    /**
     * 0 表示记录完整，1表示记录不全
     */
    private Integer pairFlag;

    private List<AttendanceCausa> causaRecords;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getDeptPid() {
        return deptPid;
    }

    public void setDeptPid(Integer deptPid) {
        this.deptPid = deptPid;
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

    public Date getAttendDate() {
        return attendDate;
    }

    public void setAttendDate(Date attendDate) {
        this.attendDate = attendDate;
    }

    public Long getLateMinUnit() {
        return lateMinUnit;
    }

    public void setLateMinUnit(Long lateMinUnit) {
        this.lateMinUnit = lateMinUnit;
    }

    public Long getOverMinUnit() {
        return overMinUnit;
    }

    public void setOverMinUnit(Long overMinUnit) {
        this.overMinUnit = overMinUnit;
    }

    public Byte getAttendRuleId() {
        return attendRuleId;
    }

    public void setAttendRuleId(Byte attendRuleId) {
        this.attendRuleId = attendRuleId;
    }

    public String getSignInTimeAm() {
        return signInTimeAm;
    }

    public void setSignInTimeAm(String signInTimeAm) {
        this.signInTimeAm = signInTimeAm;
    }

    public String getSignOutTimeAm() {
        return signOutTimeAm;
    }

    public void setSignOutTimeAm(String signOutTimeAm) {
        this.signOutTimeAm = signOutTimeAm;
    }

    public String getSignInTimePm() {
        return signInTimePm;
    }

    public void setSignInTimePm(String signInTimePm) {
        this.signInTimePm = signInTimePm;
    }

    public String getSignOutTimePm() {
        return signOutTimePm;
    }

    public void setSignOutTimePm(String signOutTimePm) {
        this.signOutTimePm = signOutTimePm;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public Integer getReviewFlag() {
        return reviewFlag;
    }

    public void setReviewFlag(Integer reviewFlag) {
        this.reviewFlag = reviewFlag;
    }

    public String getReviewRemark() {
        return reviewRemark;
    }

    public void setReviewRemark(String reviewRemark) {
        this.reviewRemark = reviewRemark;
    }

    public Float getAbsenceTime() {
        return absenceTime;
    }

    public void setAbsenceTime(Float absenceTime) {
        this.absenceTime = absenceTime;
    }

    public Float getActualTime() {
        return actualTime;
    }

    public void setActualTime(Float actualTime) {
        this.actualTime = actualTime;
    }

    public Float getOverTime() {
        return overTime;
    }

    public void setOverTime(Float overTime) {
        this.overTime = overTime;
    }

    public Integer getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(Integer leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public String getLeaveRemark() {
        return leaveRemark;
    }

    public void setLeaveRemark(String leaveRemark) {
        this.leaveRemark = leaveRemark;
    }

    public String getComputeDetail() {
        return computeDetail;
    }

    public void setComputeDetail(String computeDetail) {
        this.computeDetail = computeDetail;
    }

    public Integer getPairFlag() {
        return pairFlag;
    }

    public void setPairFlag(Integer pairFlag) {
        this.pairFlag = pairFlag;
    }

    public List<AttendanceCausa> getCausaRecords() {
        return causaRecords;
    }

    public void setCausaRecords(List<AttendanceCausa> causaRecords) {
        this.causaRecords = causaRecords;
    }
}
