package com.czht.smartpark.tbweb.modular.dto;

import java.util.Date;

/**
 * 在岗状态记录
 */
public class OnWorkPassDTO {

    private Long recordId;

    private Integer userId;

    private String userName;

    /**
     * 证件找
     */
    private byte[] userPic;

    /**
     * 最后一次通行的时间
     */
    private Date lastPasstime;

    /**
     * 最后一次通行的方向
     */
    private String lastDirect;

    private Integer deptId;

    private String deptName;

    private Integer areaId;

    private String areaName;

    /**
     * 在岗状态
     */
    private String onworkStatus;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
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

    public Date getLastPasstime() {
        return lastPasstime;
    }

    public void setLastPasstime(Date lastPasstime) {
        this.lastPasstime = lastPasstime;
    }

    public String getLastDirect() {
        return lastDirect;
    }

    public void setLastDirect(String lastDirect) {
        this.lastDirect = lastDirect;
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

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getOnworkStatus() {
        return onworkStatus;
    }

    public void setOnworkStatus(String onworkStatus) {
        this.onworkStatus = onworkStatus;
    }

    public byte[] getUserPic() {
        return userPic;
    }

    public void setUserPic(byte[] userPic) {
        this.userPic = userPic;
    }

}
