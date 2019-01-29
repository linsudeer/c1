package com.czht.smartpark.tbweb.modular.dto;

import java.util.Date;

/**
 * 通行记录modal
 */
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
}
