package com.czht.smartpark.tbweb.modular.dmo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_pass_record_today")
public class PassRecordToday {
    @Id
    @Column(name = "new_pass_record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newPassRecordId;

    @Column(name = "pass_record_id")
    private Long passRecordId;

    @Column(name = "pass_datetime")
    private Date passDatetime;

    /**
     * 哪种方式产生的通行记录{0：在线人脸识别，1：离线人脸识别，2：指纹识别，3：密码，4：身份证，5：门禁卡，6：门铃}
     */
    @Column(name = "way_of_pass")
    private Integer wayOfPass;

    /**
     * 注册标记，1注册人员，0未注册人员
     */
    @Column(name = "register_flag")
    private Integer registerFlag;

    @Column(name = "similarity_degree")
    private Float similarityDegree;

    @Column(name = "user_id")
    private Long userId;

    /**
     * 设备id
     */
    @Column(name = "device_id")
    private Integer deviceId;

    @Column(name = "user_name")
    private String userName;

    /**
     * 用户性别
     */
    @Column(name = "user_sex")
    private Integer userSex;

    @Column(name = "user_type")
    private Integer userType;

    /**
     * 人员分组(USRR_GROUP)
     */
    @Column(name = "user_group")
    private Integer userGroup;

    /**
     * 人员分组id
     */
    @Column(name = "group_id")
    private Integer groupId;

    /**
     * 部门id
     */
    @Column(name = "dept_id")
    private Integer deptId;

    /**
     * 人员所在部门上级部门or楼层
     */
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

    /**
     * 1-设备不再库中 2-未过阈值 3-设备允许 4-不允许
     */
    @Column(name = "device_auth")
    private Integer deviceAuth;

    /**
     * 1-时间允许 2-时间不允许
     */
    @Column(name = "time_auth")
    private Integer timeAuth;

    @Column(name = "live_auth")
    private Integer liveAuth;

    @Column(name = "facesize_auth")
    private Integer facesizeAuth;

    /**
     * 过滤标记，默认(1),1表示与之前记录有重复,0 未重复
     */
    @Column(name = "filter_flag")
    private Integer filterFlag;

    /**
     * 过滤的时间，单位秒
     */
    @Column(name = "filter_time")
    private Long filterTime;

    /**
     * 以图搜图归类时使用
     */
    @Column(name = "search_id")
    private Long searchId;

    /**
     * 归类使用
     */
    @Column(name = "classify_id")
    private Long classifyId;

    /**
     * 归类时相似度得分0-100
     */
    @Column(name = "classify_score")
    private Float classifyScore;

    /**
     * 抓拍全图在fdfs系统中的id
     */
    @Column(name = "full_fdfs_id")
    private String fullFdfsId;

    @Column(name = "face_fdfs_id")
    private String faceFdfsId;

    /**
     * 图像质量等级，1，一般，2很好
     */
    @Column(name = "pic_quality")
    private Integer picQuality;

    /**
     * 图像得分，满分100
     */
    @Column(name = "pic_score")
    private Float picScore;

    @Column(name = "pass_feature_id")
    private Long passFeatureId;

    /**
     * 锁定标记，禁止删除图片
     */
    @Column(name = "lock_flag")
    private Integer lockFlag;

    /**
     * 自动生成，创建时间
     */
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

    /**
     * @return new_pass_record_id
     */
    public Long getNewPassRecordId() {
        return newPassRecordId;
    }

    /**
     * @param newPassRecordId
     */
    public void setNewPassRecordId(Long newPassRecordId) {
        this.newPassRecordId = newPassRecordId;
    }

    /**
     * @return pass_record_id
     */
    public Long getPassRecordId() {
        return passRecordId;
    }

    /**
     * @param passRecordId
     */
    public void setPassRecordId(Long passRecordId) {
        this.passRecordId = passRecordId;
    }

    /**
     * @return pass_datetime
     */
    public Date getPassDatetime() {
        return passDatetime;
    }

    /**
     * @param passDatetime
     */
    public void setPassDatetime(Date passDatetime) {
        this.passDatetime = passDatetime;
    }

    /**
     * 获取哪种方式产生的通行记录{0：在线人脸识别，1：离线人脸识别，2：指纹识别，3：密码，4：身份证，5：门禁卡，6：门铃}
     *
     * @return way_of_pass - 哪种方式产生的通行记录{0：在线人脸识别，1：离线人脸识别，2：指纹识别，3：密码，4：身份证，5：门禁卡，6：门铃}
     */
    public Integer getWayOfPass() {
        return wayOfPass;
    }

    /**
     * 设置哪种方式产生的通行记录{0：在线人脸识别，1：离线人脸识别，2：指纹识别，3：密码，4：身份证，5：门禁卡，6：门铃}
     *
     * @param wayOfPass 哪种方式产生的通行记录{0：在线人脸识别，1：离线人脸识别，2：指纹识别，3：密码，4：身份证，5：门禁卡，6：门铃}
     */
    public void setWayOfPass(Integer wayOfPass) {
        this.wayOfPass = wayOfPass;
    }

    /**
     * 获取注册标记，1注册人员，0未注册人员
     *
     * @return register_flag - 注册标记，1注册人员，0未注册人员
     */
    public Integer getRegisterFlag() {
        return registerFlag;
    }

    /**
     * 设置注册标记，1注册人员，0未注册人员
     *
     * @param registerFlag 注册标记，1注册人员，0未注册人员
     */
    public void setRegisterFlag(Integer registerFlag) {
        this.registerFlag = registerFlag;
    }

    /**
     * @return similarity_degree
     */
    public Float getSimilarityDegree() {
        return similarityDegree;
    }

    /**
     * @param similarityDegree
     */
    public void setSimilarityDegree(Float similarityDegree) {
        this.similarityDegree = similarityDegree;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取设备id
     *
     * @return device_id - 设备id
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * 设置设备id
     *
     * @param deviceId 设备id
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
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
     * 获取用户性别
     *
     * @return user_sex - 用户性别
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * 设置用户性别
     *
     * @param userSex 用户性别
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * @return user_type
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * @param userType
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取人员分组(USRR_GROUP)
     *
     * @return user_group - 人员分组(USRR_GROUP)
     */
    public Integer getUserGroup() {
        return userGroup;
    }

    /**
     * 设置人员分组(USRR_GROUP)
     *
     * @param userGroup 人员分组(USRR_GROUP)
     */
    public void setUserGroup(Integer userGroup) {
        this.userGroup = userGroup;
    }

    /**
     * 获取人员分组id
     *
     * @return group_id - 人员分组id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 设置人员分组id
     *
     * @param groupId 人员分组id
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取部门id
     *
     * @return dept_id - 部门id
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 设置部门id
     *
     * @param deptId 部门id
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取人员所在部门上级部门or楼层
     *
     * @return dept_parent_id - 人员所在部门上级部门or楼层
     */
    public Integer getDeptParentId() {
        return deptParentId;
    }

    /**
     * 设置人员所在部门上级部门or楼层
     *
     * @param deptParentId 人员所在部门上级部门or楼层
     */
    public void setDeptParentId(Integer deptParentId) {
        this.deptParentId = deptParentId;
    }

    /**
     * @return device_name
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * @param deviceName
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * @return device_type
     */
    public Integer getDeviceType() {
        return deviceType;
    }

    /**
     * @param deviceType
     */
    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * @return device_direction
     */
    public Integer getDeviceDirection() {
        return deviceDirection;
    }

    /**
     * @param deviceDirection
     */
    public void setDeviceDirection(Integer deviceDirection) {
        this.deviceDirection = deviceDirection;
    }

    /**
     * @return device_area_id
     */
    public Integer getDeviceAreaId() {
        return deviceAreaId;
    }

    /**
     * @param deviceAreaId
     */
    public void setDeviceAreaId(Integer deviceAreaId) {
        this.deviceAreaId = deviceAreaId;
    }

    /**
     * @return device_entrance_id
     */
    public Integer getDeviceEntranceId() {
        return deviceEntranceId;
    }

    /**
     * @param deviceEntranceId
     */
    public void setDeviceEntranceId(Integer deviceEntranceId) {
        this.deviceEntranceId = deviceEntranceId;
    }

    /**
     * @return device_parent_id
     */
    public Integer getDeviceParentId() {
        return deviceParentId;
    }

    /**
     * @param deviceParentId
     */
    public void setDeviceParentId(Integer deviceParentId) {
        this.deviceParentId = deviceParentId;
    }

    /**
     * 获取1-设备不再库中 2-未过阈值 3-设备允许 4-不允许
     *
     * @return device_auth - 1-设备不再库中 2-未过阈值 3-设备允许 4-不允许
     */
    public Integer getDeviceAuth() {
        return deviceAuth;
    }

    /**
     * 设置1-设备不再库中 2-未过阈值 3-设备允许 4-不允许
     *
     * @param deviceAuth 1-设备不再库中 2-未过阈值 3-设备允许 4-不允许
     */
    public void setDeviceAuth(Integer deviceAuth) {
        this.deviceAuth = deviceAuth;
    }

    /**
     * 获取1-时间允许 2-时间不允许
     *
     * @return time_auth - 1-时间允许 2-时间不允许
     */
    public Integer getTimeAuth() {
        return timeAuth;
    }

    /**
     * 设置1-时间允许 2-时间不允许
     *
     * @param timeAuth 1-时间允许 2-时间不允许
     */
    public void setTimeAuth(Integer timeAuth) {
        this.timeAuth = timeAuth;
    }

    /**
     * @return live_auth
     */
    public Integer getLiveAuth() {
        return liveAuth;
    }

    /**
     * @param liveAuth
     */
    public void setLiveAuth(Integer liveAuth) {
        this.liveAuth = liveAuth;
    }

    /**
     * @return facesize_auth
     */
    public Integer getFacesizeAuth() {
        return facesizeAuth;
    }

    /**
     * @param facesizeAuth
     */
    public void setFacesizeAuth(Integer facesizeAuth) {
        this.facesizeAuth = facesizeAuth;
    }

    /**
     * 获取过滤标记，默认(1),1表示与之前记录有重复,0 未重复
     *
     * @return filter_flag - 过滤标记，默认(1),1表示与之前记录有重复,0 未重复
     */
    public Integer getFilterFlag() {
        return filterFlag;
    }

    /**
     * 设置过滤标记，默认(1),1表示与之前记录有重复,0 未重复
     *
     * @param filterFlag 过滤标记，默认(1),1表示与之前记录有重复,0 未重复
     */
    public void setFilterFlag(Integer filterFlag) {
        this.filterFlag = filterFlag;
    }

    /**
     * 获取过滤的时间，单位秒
     *
     * @return filter_time - 过滤的时间，单位秒
     */
    public Long getFilterTime() {
        return filterTime;
    }

    /**
     * 设置过滤的时间，单位秒
     *
     * @param filterTime 过滤的时间，单位秒
     */
    public void setFilterTime(Long filterTime) {
        this.filterTime = filterTime;
    }

    /**
     * 获取以图搜图归类时使用
     *
     * @return search_id - 以图搜图归类时使用
     */
    public Long getSearchId() {
        return searchId;
    }

    /**
     * 设置以图搜图归类时使用
     *
     * @param searchId 以图搜图归类时使用
     */
    public void setSearchId(Long searchId) {
        this.searchId = searchId;
    }

    /**
     * 获取归类使用
     *
     * @return classify_id - 归类使用
     */
    public Long getClassifyId() {
        return classifyId;
    }

    /**
     * 设置归类使用
     *
     * @param classifyId 归类使用
     */
    public void setClassifyId(Long classifyId) {
        this.classifyId = classifyId;
    }

    /**
     * 获取归类时相似度得分0-100
     *
     * @return classify_score - 归类时相似度得分0-100
     */
    public Float getClassifyScore() {
        return classifyScore;
    }

    /**
     * 设置归类时相似度得分0-100
     *
     * @param classifyScore 归类时相似度得分0-100
     */
    public void setClassifyScore(Float classifyScore) {
        this.classifyScore = classifyScore;
    }

    /**
     * 获取抓拍全图在fdfs系统中的id
     *
     * @return full_fdfs_id - 抓拍全图在fdfs系统中的id
     */
    public String getFullFdfsId() {
        return fullFdfsId;
    }

    /**
     * 设置抓拍全图在fdfs系统中的id
     *
     * @param fullFdfsId 抓拍全图在fdfs系统中的id
     */
    public void setFullFdfsId(String fullFdfsId) {
        this.fullFdfsId = fullFdfsId;
    }

    /**
     * @return face_fdfs_id
     */
    public String getFaceFdfsId() {
        return faceFdfsId;
    }

    /**
     * @param faceFdfsId
     */
    public void setFaceFdfsId(String faceFdfsId) {
        this.faceFdfsId = faceFdfsId;
    }

    /**
     * 获取图像质量等级，1，一般，2很好
     *
     * @return pic_quality - 图像质量等级，1，一般，2很好
     */
    public Integer getPicQuality() {
        return picQuality;
    }

    /**
     * 设置图像质量等级，1，一般，2很好
     *
     * @param picQuality 图像质量等级，1，一般，2很好
     */
    public void setPicQuality(Integer picQuality) {
        this.picQuality = picQuality;
    }

    /**
     * 获取图像得分，满分100
     *
     * @return pic_score - 图像得分，满分100
     */
    public Float getPicScore() {
        return picScore;
    }

    /**
     * 设置图像得分，满分100
     *
     * @param picScore 图像得分，满分100
     */
    public void setPicScore(Float picScore) {
        this.picScore = picScore;
    }

    /**
     * @return pass_feature_id
     */
    public Long getPassFeatureId() {
        return passFeatureId;
    }

    /**
     * @param passFeatureId
     */
    public void setPassFeatureId(Long passFeatureId) {
        this.passFeatureId = passFeatureId;
    }

    /**
     * 获取锁定标记，禁止删除图片
     *
     * @return lock_flag - 锁定标记，禁止删除图片
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * 设置锁定标记，禁止删除图片
     *
     * @param lockFlag 锁定标记，禁止删除图片
     */
    public void setLockFlag(Integer lockFlag) {
        this.lockFlag = lockFlag;
    }

    /**
     * 获取自动生成，创建时间
     *
     * @return create_datetime - 自动生成，创建时间
     */
    public Date getCreateDatetime() {
        return createDatetime;
    }

    /**
     * 设置自动生成，创建时间
     *
     * @param createDatetime 自动生成，创建时间
     */
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    /**
     * @return reserve_int
     */
    public Integer getReserveInt() {
        return reserveInt;
    }

    /**
     * @param reserveInt
     */
    public void setReserveInt(Integer reserveInt) {
        this.reserveInt = reserveInt;
    }

    /**
     * @return reserve_bigint
     */
    public Long getReserveBigint() {
        return reserveBigint;
    }

    /**
     * @param reserveBigint
     */
    public void setReserveBigint(Long reserveBigint) {
        this.reserveBigint = reserveBigint;
    }

    /**
     * @return reserve_double
     */
    public Double getReserveDouble() {
        return reserveDouble;
    }

    /**
     * @param reserveDouble
     */
    public void setReserveDouble(Double reserveDouble) {
        this.reserveDouble = reserveDouble;
    }

    /**
     * @return reserve_vchar
     */
    public String getReserveVchar() {
        return reserveVchar;
    }

    /**
     * @param reserveVchar
     */
    public void setReserveVchar(String reserveVchar) {
        this.reserveVchar = reserveVchar;
    }

    /**
     * @return reserve_blob
     */
    public byte[] getReserveBlob() {
        return reserveBlob;
    }

    /**
     * @param reserveBlob
     */
    public void setReserveBlob(byte[] reserveBlob) {
        this.reserveBlob = reserveBlob;
    }
}