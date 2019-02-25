package com.czht.smartpark.tbweb.modular.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private Integer userId;
    private String userName;
    private Integer userSex;
    private String userMobile;
    private Integer deptId;
    private Integer deptPid;
    private String deptName;
    private String idCard;

    private Integer userGroup;

    private Integer userType;

    private String dataRole;

    private byte[] idPic;

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

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public byte[] getIdPic() {
        return idPic;
    }

    public void setIdPic(byte[] idPic) {
        this.idPic = idPic;
    }

    public Integer getDeptPid() {
        return deptPid;
    }

    public void setDeptPid(Integer deptPid) {
        this.deptPid = deptPid;
    }

    public Integer getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(Integer userGroup) {
        this.userGroup = userGroup;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getDataRole() {
        return dataRole;
    }

    public void setDataRole(String dataRole) {
        this.dataRole = dataRole;
    }
}
