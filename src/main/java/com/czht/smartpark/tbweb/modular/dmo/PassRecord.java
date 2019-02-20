package com.czht.smartpark.tbweb.modular.dmo;

import javax.persistence.*;
import java.util.Date;
@Table(name = "tb_pass_record")
public class PassRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passRecordId;

    @Column(name = "pass_datetime")
    private Date passDatetime;

    @Column(name = "way_of_pass")
    private Integer wayOfPass;

    @Column(name = "register_flag")
    private Integer registerFlag;

    @Column(name = "similarity_degree")
    private Float similarityDegree;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "device_id")
    private Integer deviceId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_sex")
    private Integer userSex;

    @Column(name = "user_type")
    private Integer userType;

    @Column(name = "user_group")
    private Integer userGroup;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "dept_parent_id")
    private Integer deptParentId;

    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "device_type")
    private Integer deviceType;

    @Column(name = "device_direction")
    private Integer deviceDirection;

    @Column(name = "device_area_id")
    private Integer deviceAreaId;

    @Column(name = "device_entrance_id")
    private Integer deviceEntranceId;

    @Column(name = "device_parent_id")
    private Integer deviceParentId;

    @Column(name = "device_auth")
    private Integer deviceAuth;

    @Column(name = "time_auth")
    private Integer timeAuth;

    @Column(name = "live_auth")
    private Integer liveAuth;

    @Column(name = "facesize_auth")
    private Integer facesizeAuth;

    @Column(name = "filter_flag")
    private Integer filterFlag;

    @Column(name = "filter_time")
    private Long filterTime;

    @Column(name = "search_Id")
    private Long searchId;

    @Column(name = "classify_Id")
    private Long classifyId;

    @Column(name = "classify_score")
    private Float classifyScore;

    @Column(name = "full_fdfs_Id")
    private String fullFdfsId;

    @Column(name = "face_fdfs_id")
    private String faceFdfsId;

    @Column(name = "pic_quality")
    private Integer picQuality;

    @Column(name = "pic_score")
    private Float picScore;

    @Column(name = "pass_feature_id")
    private Long passFeatureId;

    @Column(name = "lock_flag")
    private Integer lockFlag;

    @Column(name = "create_datetime")
    private Date createDatetime;

    @Column(name = "reserve_int")
    private Integer reserveInt;

    @Column(name = "reserve_bigint")
    private Long reserveBigint;

    @Column(name = "reserve_double")
    private Double reserveDouble;

    @Column(name = "reserve_vchar")
    private String reserveVchar;

    @Column(name = "reserve_blob")
    private byte[] reserveBlob;

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

    public Integer getWayOfPass() {
        return wayOfPass;
    }

    public void setWayOfPass(Integer wayOfPass) {
        this.wayOfPass = wayOfPass;
    }

    public Integer getRegisterFlag() {
        return registerFlag;
    }

    public void setRegisterFlag(Integer registerFlag) {
        this.registerFlag = registerFlag;
    }

    public Float getSimilarityDegree() {
        return similarityDegree;
    }

    public void setSimilarityDegree(Float similarityDegree) {
        this.similarityDegree = similarityDegree;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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

    public Integer getDeptParentId() {
        return deptParentId;
    }

    public void setDeptParentId(Integer deptParentId) {
        this.deptParentId = deptParentId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
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

    public Integer getDeviceAreaId() {
        return deviceAreaId;
    }

    public void setDeviceAreaId(Integer deviceAreaId) {
        this.deviceAreaId = deviceAreaId;
    }

    public Integer getDeviceEntranceId() {
        return deviceEntranceId;
    }

    public void setDeviceEntranceId(Integer deviceEntranceId) {
        this.deviceEntranceId = deviceEntranceId;
    }

    public Integer getDeviceParentId() {
        return deviceParentId;
    }

    public void setDeviceParentId(Integer deviceParentId) {
        this.deviceParentId = deviceParentId;
    }

    public Integer getDeviceAuth() {
        return deviceAuth;
    }

    public void setDeviceAuth(Integer deviceAuth) {
        this.deviceAuth = deviceAuth;
    }

    public Integer getTimeAuth() {
        return timeAuth;
    }

    public void setTimeAuth(Integer timeAuth) {
        this.timeAuth = timeAuth;
    }

    public Integer getLiveAuth() {
        return liveAuth;
    }

    public void setLiveAuth(Integer liveAuth) {
        this.liveAuth = liveAuth;
    }

    public Integer getFacesizeAuth() {
        return facesizeAuth;
    }

    public void setFacesizeAuth(Integer facesizeAuth) {
        this.facesizeAuth = facesizeAuth;
    }

    public Integer getFilterFlag() {
        return filterFlag;
    }

    public void setFilterFlag(Integer filterFlag) {
        this.filterFlag = filterFlag;
    }

    public Long getFilterTime() {
        return filterTime;
    }

    public void setFilterTime(Long filterTime) {
        this.filterTime = filterTime;
    }

    public Long getSearchId() {
        return searchId;
    }

    public void setSearchId(Long searchId) {
        this.searchId = searchId;
    }

    public Long getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Long classifyId) {
        this.classifyId = classifyId;
    }

    public Float getClassifyScore() {
        return classifyScore;
    }

    public void setClassifyScore(Float classifyScore) {
        this.classifyScore = classifyScore;
    }

    public String getFullFdfsId() {
        return fullFdfsId;
    }

    public void setFullFdfsId(String fullFdfsId) {
        this.fullFdfsId = fullFdfsId == null ? null : fullFdfsId.trim();
    }

    public String getFaceFdfsId() {
        return faceFdfsId;
    }

    public void setFaceFdfsId(String faceFdfsId) {
        this.faceFdfsId = faceFdfsId == null ? null : faceFdfsId.trim();
    }

    public Integer getPicQuality() {
        return picQuality;
    }

    public void setPicQuality(Integer picQuality) {
        this.picQuality = picQuality;
    }

    public Float getPicScore() {
        return picScore;
    }

    public void setPicScore(Float picScore) {
        this.picScore = picScore;
    }

    public Long getPassFeatureId() {
        return passFeatureId;
    }

    public void setPassFeatureId(Long passFeatureId) {
        this.passFeatureId = passFeatureId;
    }

    public Integer getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(Integer lockFlag) {
        this.lockFlag = lockFlag;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Integer getReserveInt() {
        return reserveInt;
    }

    public void setReserveInt(Integer reserveInt) {
        this.reserveInt = reserveInt;
    }

    public Long getReserveBigint() {
        return reserveBigint;
    }

    public void setReserveBigint(Long reserveBigint) {
        this.reserveBigint = reserveBigint;
    }

    public Double getReserveDouble() {
        return reserveDouble;
    }

    public void setReserveDouble(Double reserveDouble) {
        this.reserveDouble = reserveDouble;
    }

    public String getReserveVchar() {
        return reserveVchar;
    }

    public void setReserveVchar(String reserveVchar) {
        this.reserveVchar = reserveVchar == null ? null : reserveVchar.trim();
    }

    public byte[] getReserveBlob() {
        return reserveBlob;
    }

    public void setReserveBlob(byte[] reserveBlob) {
        this.reserveBlob = reserveBlob;
    }

}