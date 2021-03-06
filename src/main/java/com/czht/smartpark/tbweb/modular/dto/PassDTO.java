package com.czht.smartpark.tbweb.modular.dto;

import com.czht.smartpark.tbweb.modular.dmo.SysOplog;
import com.czht.smartpark.tbweb.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

/**
 * 通行记录modal
 */

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class PassDTO {

    private Long passRecordId;

    private Date passDatetime;

    private Long userId;

    private Integer deviceId;

    private Integer deviceType;

    private Integer deviceDirection;

    private String direct;

    private String deviceName;

    private Integer deviceAreaId;

    private String deviceAreaName;

    private String userName;

    private Integer userSex;

    private Integer userType;

    private Integer userGroup;

    private String userGroupName;

    private Integer groupId;

    private Integer deptId;

    private String deptName;

    private Integer deptParentId;

    private String fullFdfsId;

    private String faceFdfsId;

    /**
     * 修改标识
     */
    private Integer reviewFlag;

    private List<SysOplog> logs;

    /**
     * 过滤标识，1-被过滤 0-正常
     */
    private Integer filterFlag;

    public Long getPassRecordId() {
        return passRecordId;
    }

    public void setPassRecordId(Long passRecordId) {
        this.passRecordId = passRecordId;
    }

    public Date getPassDatetime() {
        return passDatetime;
    }

    public void setPassDatetime(Date passDatetime) {
        this.passDatetime = passDatetime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getDeviceDirection() {
        return deviceDirection;
    }

    public void setDeviceDirection(Integer deviceDirection) {
        this.deviceDirection = deviceDirection;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getDeviceAreaId() {
        return deviceAreaId;
    }

    public void setDeviceAreaId(Integer deviceAreaId) {
        this.deviceAreaId = deviceAreaId;
    }

    public String getDeviceAreaName() {
        return deviceAreaName;
    }

    public void setDeviceAreaName(String deviceAreaName) {
        this.deviceAreaName = deviceAreaName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(Integer userGroup) {
        this.userGroup = userGroup;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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

    public Integer getDeptParentId() {
        return deptParentId;
    }

    public void setDeptParentId(Integer deptParentId) {
        this.deptParentId = deptParentId;
    }

    public String getFullFdfsId() {
        return fullFdfsId;
    }

    public void setFullFdfsId(String fullFdfsId) {
        this.fullFdfsId = fullFdfsId;
    }

    public String getFaceFdfsId() {
        return faceFdfsId;
    }

    public void setFaceFdfsId(String faceFdfsId) {
        this.faceFdfsId = faceFdfsId;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public Integer getReviewFlag() {
        return reviewFlag;
    }

    public void setReviewFlag(Integer reviewFlag) {
        this.reviewFlag = reviewFlag;
    }

    public List<SysOplog> getLogs() {
        return logs;
    }

    public void setLogs(List<SysOplog> logs) {
        this.logs = logs;
    }

    public Integer getFilterFlag() {
        return filterFlag;
    }

    public void setFilterFlag(Integer filterFlag) {
        this.filterFlag = filterFlag;
    }

    @Override
    public String toString() {
        return "PassDTO{" +
                "passRecordId=" + passRecordId +
                ", passDatetime=" + DateUtil.format(passDatetime, "yyyy-MM-dd HH:mm:ss") +
                ", userId=" + userId +
                ", deviceId=" + deviceId +
                ", deviceType=" + deviceType +
                ", deviceDirection=" + deviceDirection +
                ", direct='" + direct + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceAreaId=" + deviceAreaId +
                ", deviceAreaName='" + deviceAreaName + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userType=" + userType +
                ", userGroup=" + userGroup +
                ", userGroupName='" + userGroupName + '\'' +
                ", groupId=" + groupId +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptParentId=" + deptParentId +
                ", fullFdfsId='" + fullFdfsId + '\'' +
                ", faceFdfsId='" + faceFdfsId + '\'' +
                ", reviewFlag=" + reviewFlag +
                ", logs=" + logs +
                '}';
    }
}
