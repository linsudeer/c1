package com.czht.smartpark.tbweb.modular.dmo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_attendance_record_tb")
public class AttendanceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "dept_pid")
    private Integer deptPid;

    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "dept_name")
    private String deptName;

    /**
     * 考勤日期
     */
    @Column(name = "attend_date")
    private Date attendDate;

    /**
     * 迟到超过多少分钟算迟到
     */
    @Column(name = "late_min_unit")
    private Long lateMinUnit;

    /**
     * 加班超过多少分钟算迟到
     */
    @Column(name = "over_min_unit")
    private Long overMinUnit;

    /**
     * 考勤规则ID（FK），规则的类型是创建不可更改，所以不需要存考勤类型
     */
    @Column(name = "attend_rule_id")
    private Byte attendRuleId;

    /**
     * 上午签到打卡时间：设备方向为进的时间点中最小的
     */
    @Column(name = "sign_in_time_am")
    private Date signInTimeAm;

    /**
     * 上午签退打卡时间：设备方向为出的时间点中最大的
     */
    @Column(name = "sign_out_time_am")
    private Date signOutTimeAm;

    /**
     * 下午签到打卡时间：设备方向为进的时间点中最小的
     */
    @Column(name = "sign_in_time_pm")
    private Date signInTimePm;

    /**
     * 下午签退打卡时间：设备方向为出的时间点中最大的
     */
    @Column(name = "sign_out_time_pm")
    private Date signOutTimePm;

    private String week;

    /**
     * 是否修正（0：未修正；1：已修正）
     */
    @Column(name = "review_flag")
    private Integer reviewFlag;

    /**
     * 如果修正过，修正的原因
     */
    @Column(name = "review_remark")
    private String reviewRemark;

    /**
     * 应出勤时长，如果有临时外出，请假等情况，应出勤时长会减小
     */
    @Column(name = "absence_time")
    private Float absenceTime;

    /**
     * 实际出勤时长
     */
    @Column(name = "actual_time")
    private Float actualTime;

    /**
     * 加班时长，这里是在加班点计算的加班时长
     */
    @Column(name = "over_time")
    private Float overTime;

    /**
     * 请假标识默认0-正常上班  1-请假 2-节假日 3-大队执勤等不属于请假的范畴
     */
    @Column(name = "leave_status")
    private Integer leaveStatus;

    /**
     * 请假描述，出差，还是事假,还是什么节假日
     */
    @Column(name = "leave_remark")
    private String leaveRemark;

    /**
     * 计算详情，考勤是怎么计算出来的，例如（上午出勤多久，下午出勤多久，是否临时离岗，以及临时离岗时间等）
     */
    @Column(name = "compute_detail")
    private String computeDetail;

    /**
     * 0 表示记录完整，1表示记录不全
     */
    @Column(name = "pair_flag")
    private Integer pairFlag;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return dept_pid
     */
    public Integer getDeptPid() {
        return deptPid;
    }

    /**
     * @param deptPid
     */
    public void setDeptPid(Integer deptPid) {
        this.deptPid = deptPid;
    }

    /**
     * @return dept_id
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * @param deptId
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * @return dept_name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取考勤日期
     *
     * @return attend_date - 考勤日期
     */
    public Date getAttendDate() {
        return attendDate;
    }

    /**
     * 设置考勤日期
     *
     * @param attendDate 考勤日期
     */
    public void setAttendDate(Date attendDate) {
        this.attendDate = attendDate;
    }

    /**
     * 获取迟到超过多少分钟算迟到
     *
     * @return late_min_unit - 迟到超过多少分钟算迟到
     */
    public Long getLateMinUnit() {
        return lateMinUnit;
    }

    /**
     * 设置迟到超过多少分钟算迟到
     *
     * @param lateMinUnit 迟到超过多少分钟算迟到
     */
    public void setLateMinUnit(Long lateMinUnit) {
        this.lateMinUnit = lateMinUnit;
    }

    /**
     * 获取加班超过多少分钟算迟到
     *
     * @return over_min_unit - 加班超过多少分钟算迟到
     */
    public Long getOverMinUnit() {
        return overMinUnit;
    }

    /**
     * 设置加班超过多少分钟算迟到
     *
     * @param overMinUnit 加班超过多少分钟算迟到
     */
    public void setOverMinUnit(Long overMinUnit) {
        this.overMinUnit = overMinUnit;
    }

    /**
     * 获取考勤规则ID（FK），规则的类型是创建不可更改，所以不需要存考勤类型
     *
     * @return attend_rule_id - 考勤规则ID（FK），规则的类型是创建不可更改，所以不需要存考勤类型
     */
    public Byte getAttendRuleId() {
        return attendRuleId;
    }

    /**
     * 设置考勤规则ID（FK），规则的类型是创建不可更改，所以不需要存考勤类型
     *
     * @param attendRuleId 考勤规则ID（FK），规则的类型是创建不可更改，所以不需要存考勤类型
     */
    public void setAttendRuleId(Byte attendRuleId) {
        this.attendRuleId = attendRuleId;
    }

    /**
     * 获取上午签到打卡时间：设备方向为进的时间点中最小的
     *
     * @return sign_in_time_am - 上午签到打卡时间：设备方向为进的时间点中最小的
     */
    public Date getSignInTimeAm() {
        return signInTimeAm;
    }

    /**
     * 设置上午签到打卡时间：设备方向为进的时间点中最小的
     *
     * @param signInTimeAm 上午签到打卡时间：设备方向为进的时间点中最小的
     */
    public void setSignInTimeAm(Date signInTimeAm) {
        this.signInTimeAm = signInTimeAm;
    }

    /**
     * 获取上午签退打卡时间：设备方向为出的时间点中最大的
     *
     * @return sign_out_time_am - 上午签退打卡时间：设备方向为出的时间点中最大的
     */
    public Date getSignOutTimeAm() {
        return signOutTimeAm;
    }

    /**
     * 设置上午签退打卡时间：设备方向为出的时间点中最大的
     *
     * @param signOutTimeAm 上午签退打卡时间：设备方向为出的时间点中最大的
     */
    public void setSignOutTimeAm(Date signOutTimeAm) {
        this.signOutTimeAm = signOutTimeAm;
    }

    /**
     * 获取下午签到打卡时间：设备方向为进的时间点中最小的
     *
     * @return sign_in_time_pm - 下午签到打卡时间：设备方向为进的时间点中最小的
     */
    public Date getSignInTimePm() {
        return signInTimePm;
    }

    /**
     * 设置下午签到打卡时间：设备方向为进的时间点中最小的
     *
     * @param signInTimePm 下午签到打卡时间：设备方向为进的时间点中最小的
     */
    public void setSignInTimePm(Date signInTimePm) {
        this.signInTimePm = signInTimePm;
    }

    /**
     * 获取下午签退打卡时间：设备方向为出的时间点中最大的
     *
     * @return sign_out_time_pm - 下午签退打卡时间：设备方向为出的时间点中最大的
     */
    public Date getSignOutTimePm() {
        return signOutTimePm;
    }

    /**
     * 设置下午签退打卡时间：设备方向为出的时间点中最大的
     *
     * @param signOutTimePm 下午签退打卡时间：设备方向为出的时间点中最大的
     */
    public void setSignOutTimePm(Date signOutTimePm) {
        this.signOutTimePm = signOutTimePm;
    }

    /**
     * @return week
     */
    public String getWeek() {
        return week;
    }

    /**
     * @param week
     */
    public void setWeek(String week) {
        this.week = week;
    }

    /**
     * 获取是否修正（0：未修正；1：已修正）
     *
     * @return review_flag - 是否修正（0：未修正；1：已修正）
     */
    public Integer getReviewFlag() {
        return reviewFlag;
    }

    /**
     * 设置是否修正（0：未修正；1：已修正）
     *
     * @param reviewFlag 是否修正（0：未修正；1：已修正）
     */
    public void setReviewFlag(Integer reviewFlag) {
        this.reviewFlag = reviewFlag;
    }

    /**
     * 获取如果修正过，修正的原因
     *
     * @return review_remark - 如果修正过，修正的原因
     */
    public String getReviewRemark() {
        return reviewRemark;
    }

    /**
     * 设置如果修正过，修正的原因
     *
     * @param reviewRemark 如果修正过，修正的原因
     */
    public void setReviewRemark(String reviewRemark) {
        this.reviewRemark = reviewRemark;
    }

    /**
     * 获取应出勤时长，如果有临时外出，请假等情况，应出勤时长会减小
     *
     * @return absence_time - 应出勤时长，如果有临时外出，请假等情况，应出勤时长会减小
     */
    public Float getAbsenceTime() {
        return absenceTime;
    }

    /**
     * 设置应出勤时长，如果有临时外出，请假等情况，应出勤时长会减小
     *
     * @param absenceTime 应出勤时长，如果有临时外出，请假等情况，应出勤时长会减小
     */
    public void setAbsenceTime(Float absenceTime) {
        this.absenceTime = absenceTime;
    }

    /**
     * 获取实际出勤时长
     *
     * @return actual_time - 实际出勤时长
     */
    public Float getActualTime() {
        return actualTime;
    }

    /**
     * 设置实际出勤时长
     *
     * @param actualTime 实际出勤时长
     */
    public void setActualTime(Float actualTime) {
        this.actualTime = actualTime;
    }

    /**
     * 获取加班时长，这里是在加班点计算的加班时长
     *
     * @return over_time - 加班时长，这里是在加班点计算的加班时长
     */
    public Float getOverTime() {
        return overTime;
    }

    /**
     * 设置加班时长，这里是在加班点计算的加班时长
     *
     * @param overTime 加班时长，这里是在加班点计算的加班时长
     */
    public void setOverTime(Float overTime) {
        this.overTime = overTime;
    }

    /**
     * 获取请假标识默认0-正常上班  1-请假 2-节假日 3-大队执勤等不属于请假的范畴
     *
     * @return leave_status - 请假标识默认0-正常上班  1-请假 2-节假日 3-大队执勤等不属于请假的范畴
     */
    public Integer getLeaveStatus() {
        return leaveStatus;
    }

    /**
     * 设置请假标识默认0-正常上班  1-请假 2-节假日 3-大队执勤等不属于请假的范畴
     *
     * @param leaveStatus 请假标识默认0-正常上班  1-请假 2-节假日 3-大队执勤等不属于请假的范畴
     */
    public void setLeaveStatus(Integer leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    /**
     * 获取请假描述，出差，还是事假,还是什么节假日
     *
     * @return leave_remark - 请假描述，出差，还是事假,还是什么节假日
     */
    public String getLeaveRemark() {
        return leaveRemark;
    }

    /**
     * 设置请假描述，出差，还是事假,还是什么节假日
     *
     * @param leaveRemark 请假描述，出差，还是事假,还是什么节假日
     */
    public void setLeaveRemark(String leaveRemark) {
        this.leaveRemark = leaveRemark;
    }

    /**
     * 获取计算详情，考勤是怎么计算出来的，例如（上午出勤多久，下午出勤多久，是否临时离岗，以及临时离岗时间等）
     *
     * @return compute_detail - 计算详情，考勤是怎么计算出来的，例如（上午出勤多久，下午出勤多久，是否临时离岗，以及临时离岗时间等）
     */
    public String getComputeDetail() {
        return computeDetail;
    }

    /**
     * 设置计算详情，考勤是怎么计算出来的，例如（上午出勤多久，下午出勤多久，是否临时离岗，以及临时离岗时间等）
     *
     * @param computeDetail 计算详情，考勤是怎么计算出来的，例如（上午出勤多久，下午出勤多久，是否临时离岗，以及临时离岗时间等）
     */
    public void setComputeDetail(String computeDetail) {
        this.computeDetail = computeDetail;
    }

    /**
     * 获取0 表示记录完整，1表示记录不全
     *
     * @return pair_flag - 0 表示记录完整，1表示记录不全
     */
    public Integer getPairFlag() {
        return pairFlag;
    }

    /**
     * 设置0 表示记录完整，1表示记录不全
     *
     * @param pairFlag 0 表示记录完整，1表示记录不全
     */
    public void setPairFlag(Integer pairFlag) {
        this.pairFlag = pairFlag;
    }

    /**
     * 获取更新时间
     *
     * @return updated - 更新时间
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * 设置更新时间
     *
     * @param updated 更新时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * 获取创建时间
     *
     * @return created - 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置创建时间
     *
     * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }
}