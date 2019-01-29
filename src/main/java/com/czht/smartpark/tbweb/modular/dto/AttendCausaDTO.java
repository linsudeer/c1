package com.czht.smartpark.tbweb.modular.dto;

import java.util.Date;

/**
 * 不正常考勤实体
 */
public class AttendCausaDTO {

    /**
     * 考勤记录的id
     */
    private Integer attendId;

    /**
     * 异常的时间
     */
    private Date time;

    /**
     * 异常类型 1-迟到 2 早退 3-矿工
     */
    private Integer type;

    /**
     * 异常类型（上午迟到，上午早退，下午迟到，下午早退，上午离岗，下午离岗等）
     */
    private String causalName;

    public Integer getAttendId() {
        return attendId;
    }

    public void setAttendId(Integer attendId) {
        this.attendId = attendId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCausalName() {
        return causalName;
    }

    public void setCausalName(String causalName) {
        this.causalName = causalName;
    }
}
