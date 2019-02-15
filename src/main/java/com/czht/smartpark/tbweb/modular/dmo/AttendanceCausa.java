package com.czht.smartpark.tbweb.modular.dmo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_attendance_causa_tb")
public class AttendanceCausa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 对应的考勤记录ID
     */
    @Column(name = "attend_id")
    private Integer attendId;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * 考勤的日期
     */
    @Column(name = "attend_date")
    private Date attendDate;

    /**
     * 异常的时间点，-1表示没有时间，0表示没有记录但正常，时间则标识异常的时间
     */
    private String time;

    /**
     * 1-上午迟到 2 上午早退 3-上午旷工 4-下午迟到 5-下午早退 6-下午旷工
     */
    private Integer type;

    /**
     * 异常类型（上午迟到，上午早退，下午迟到，下午早退，上午离岗，下午离岗等）
     */
    @Column(name = "causalName")
    private String causalname;

    /**
     * 修正标识，0没有修正，1修正过，属于正常
     */
    @Column(name = "review_flag")
    private Integer reviewFlag;

    /**
     * 修正的理由
     */
    @Column(name = "review_remark")
    private String reviewRemark;

    @Column(name = "review_user_id")
    private Integer reviewUserId;

    @Column(name = "review_user_name")
    private String reviewUserName;

    @Column(name = "review_time")
    private Date reviewTime;

    private Date updated;

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
     * 获取对应的考勤记录ID
     *
     * @return attend_id - 对应的考勤记录ID
     */
    public Integer getAttendId() {
        return attendId;
    }

    /**
     * 设置对应的考勤记录ID
     *
     * @param attendId 对应的考勤记录ID
     */
    public void setAttendId(Integer attendId) {
        this.attendId = attendId;
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
     * 获取考勤的日期
     *
     * @return attend_date - 考勤的日期
     */
    public Date getAttendDate() {
        return attendDate;
    }

    /**
     * 设置考勤的日期
     *
     * @param attendDate 考勤的日期
     */
    public void setAttendDate(Date attendDate) {
        this.attendDate = attendDate;
    }

    /**
     * 获取异常的时间点，-1表示没有时间，0表示没有记录但正常，时间则标识异常的时间
     *
     * @return time - 异常的时间点，-1表示没有时间，0表示没有记录但正常，时间则标识异常的时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置异常的时间点，-1表示没有时间，0表示没有记录但正常，时间则标识异常的时间
     *
     * @param time 异常的时间点，-1表示没有时间，0表示没有记录但正常，时间则标识异常的时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取1-上午迟到 2 上午早退 3-上午旷工 4-下午迟到 5-下午早退 6-下午旷工
     *
     * @return type - 1-上午迟到 2 上午早退 3-上午旷工 4-下午迟到 5-下午早退 6-下午旷工
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1-上午迟到 2 上午早退 3-上午旷工 4-下午迟到 5-下午早退 6-下午旷工
     *
     * @param type 1-上午迟到 2 上午早退 3-上午旷工 4-下午迟到 5-下午早退 6-下午旷工
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取异常类型（上午迟到，上午早退，下午迟到，下午早退，上午离岗，下午离岗等）
     *
     * @return causalName - 异常类型（上午迟到，上午早退，下午迟到，下午早退，上午离岗，下午离岗等）
     */
    public String getCausalname() {
        return causalname;
    }

    /**
     * 设置异常类型（上午迟到，上午早退，下午迟到，下午早退，上午离岗，下午离岗等）
     *
     * @param causalname 异常类型（上午迟到，上午早退，下午迟到，下午早退，上午离岗，下午离岗等）
     */
    public void setCausalname(String causalname) {
        this.causalname = causalname;
    }

    /**
     * 获取修正标识，0没有修正，1修正过，属于正常
     *
     * @return review_flag - 修正标识，0没有修正，1修正过，属于正常
     */
    public Integer getReviewFlag() {
        return reviewFlag;
    }

    /**
     * 设置修正标识，0没有修正，1修正过，属于正常
     *
     * @param reviewFlag 修正标识，0没有修正，1修正过，属于正常
     */
    public void setReviewFlag(Integer reviewFlag) {
        this.reviewFlag = reviewFlag;
    }

    /**
     * 获取修正的理由
     *
     * @return review_remark - 修正的理由
     */
    public String getReviewRemark() {
        return reviewRemark;
    }

    /**
     * 设置修正的理由
     *
     * @param reviewRemark 修正的理由
     */
    public void setReviewRemark(String reviewRemark) {
        this.reviewRemark = reviewRemark;
    }

    /**
     * @return review_user_id
     */
    public Integer getReviewUserId() {
        return reviewUserId;
    }

    /**
     * @param reviewUserId
     */
    public void setReviewUserId(Integer reviewUserId) {
        this.reviewUserId = reviewUserId;
    }

    /**
     * @return review_user_name
     */
    public String getReviewUserName() {
        return reviewUserName;
    }

    /**
     * @param reviewUserName
     */
    public void setReviewUserName(String reviewUserName) {
        this.reviewUserName = reviewUserName;
    }

    /**
     * @return review_time
     */
    public Date getReviewTime() {
        return reviewTime;
    }

    /**
     * @param reviewTime
     */
    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    /**
     * @return updated
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * @param updated
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * @return created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }
}