package com.czht.smartpark.tbweb.modular.dmo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user")
public class User {
    /**
     *   
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    /**
     * 个人平台登录密码
     */
    private String password;

    @Column(name = "user_mobile")
    private String userMobile;

    /**
     * 1 男 2 女 0 未知
     */
    @Column(name = "user_sex")
    private Integer userSex;

    /**
     * 民族
     */
    @Column(name = "user_nation")
    private Integer userNation;

    @Column(name = "user_birthday")
    private Date userBirthday;

    /**
     * 进出限制
     */
    @Column(name = "group_id")
    private Integer groupId;

    /**
     * 人员类型：内部人员（1，固定不变），访客(2，固定不变)，陌生人（0，固定不变，非tb_user表中人员）
     */
    @Column(name = "user_type")
    private Integer userType;

    /**
     * 部门id
     */
    @Column(name = "dept_id")
    private Integer deptId;

    /**
     * 部门的parent_id
     */
    @Column(name = "dept_parent_id")
    private Integer deptParentId;

    /**
     * 人员分组（教师，学生，职工）（内部员工，外部人员）（保洁，快递，送餐，司机，开发人员，项目经理，测试人员）
     */
    @Column(name = "user_group")
    private Integer userGroup;

    /**
     * 是否考勤标志 -0不考勤 -其他是考勤规则ID
     */
    @Column(name = "attendance_sign")
    private Integer attendanceSign;

    /**
     * 证件、编号类型：身份证-1，军官证-2，护照-3，批量注册编号-4，其他证件-5，客户自定义编号-6
     */
    @Column(name = "identification_type")
    private Integer identificationType;

    /**
     * 证件号码或者编号
     */
    @Column(name = "identification_number")
    private String identificationNumber;

    @Column(name = "id_card")
    private String idCard;

    /**
     * 比对阈值(针对部分个例人员)
     */
    @Column(name = "compare_threshold")
    private Double compareThreshold;

    /**
     * 访客来访事由
     */
    @Column(name = "register_cause")
    private String registerCause;

    /**
     * 接待人ID，接待人姓名和电话从tb_user根据此ID取
     */
    @Column(name = "receiver_name")
    private Integer receiverName;

    /**
     * 访客访问结束时间
     */
    @Column(name = "visit_endtime")
    private Date visitEndtime;

    /**
     * 访客访问开始时间
     */
    @Column(name = "visit_starttime")
    private Date visitStarttime;

    /**
     * 抓拍图片在人员图片表id
     */
    @Column(name = "register_pic1_id")
    private Long registerPic1Id;

    /**
     * 抓拍图片在人员图片表id
     */
    @Column(name = "register_pic2_id")
    private Long registerPic2Id;

    /**
     * 抓拍图片在人员图片表id
     */
    @Column(name = "register_pic3_id")
    private Long registerPic3Id;

    /**
     * 抓拍图片在人员图片表id
     */
    @Column(name = "register_pic4_id")
    private Long registerPic4Id;

    /**
     * 删除标记：已删除（1）未删除（0）
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

    /**
     * Web注册，注册机注册，其他客户端注册，各自代码申请注册方式编码值
     */
    @Column(name = "register_method")
    private Integer registerMethod;

    /**
     * 审核状态：已审核（1）待审核（0），各自注册方式，根据注册人员分组在tb_pf_audit_conf中的定义确定此列取值
     */
    @Column(name = "audit_status")
    private Integer auditStatus;

    /**
     * 人证比对结果： 人证比对成功（1）人证比对失败（0）非人证比对无结果（-1）
     */
    @Column(name = "compare_result")
    private Integer compareResult;

    /**
     * web端编辑人员时，操作人员的系统用户名称
     */
    @Column(name = "last_edit_manager")
    private String lastEditManager;

    /**
     * 标记批量注册批次
     */
    @Column(name = "batch_no")
    private Long batchNo;

    /**
     * 拼音全拼
     */
    @Column(name = "user_name_spell")
    private String userNameSpell;

    /**
     * 拼音简拼
     */
    @Column(name = "user_name_short")
    private String userNameShort;

    /**
     * 更新时间
     */
    @Column(name = "update_datetime")
    private Date updateDatetime;

    /**
     * 自动生成，创建时间
     */
    @Column(name = "create_datetime")
    private Date createDatetime;

    /**
     * 车牌号
     */
    @Column(name = "plate_no")
    private String plateNo;

    @Column(name = "reserve_vchar")
    private String reserveVchar;

    @Column(name = "reserve_vchar1")
    private String reserveVchar1;

    @Column(name = "reserve_vchar2")
    private String reserveVchar2;

    @Column(name = "reserve_vchar3")
    private String reserveVchar3;

    @Column(name = "reserve_vchar4")
    private String reserveVchar4;

    @Column(name = "reserve_vchar5")
    private String reserveVchar5;

    @Column(name = "reserve_int")
    private Integer reserveInt;

    @Column(name = "reserve_int1")
    private Integer reserveInt1;

    @Column(name = "reserve_int2")
    private Integer reserveInt2;

    @Column(name = "reserve_int3")
    private Integer reserveInt3;

    @Column(name = "reserve_int4")
    private Integer reserveInt4;

    @Column(name = "reserve_int5")
    private Integer reserveInt5;

    @Column(name = "reserve_bigint")
    private Long reserveBigint;

    @Column(name = "reserve_double")
    private Double reserveDouble;

    /**
     * 证件图片在人员图片表中的id
     */
    @Column(name = "identification_pic_id")
    private byte[] identificationPicId;

    /**
     * 抓拍图片在人员图片1路径
     */
    @Column(name = "register_pic1_path")
    private byte[] registerPic1Path;

    /**
     * 抓拍图片在人员图片2路径
     */
    @Column(name = "register_pic2_path")
    private byte[] registerPic2Path;

    /**
     * 抓拍图片在人员图片3路径
     */
    @Column(name = "register_pic3_path")
    private byte[] registerPic3Path;

    /**
     * 抓拍图片在人员图片4路径
     */
    @Column(name = "register_pic4_path")
    private byte[] registerPic4Path;

    /**
     * 指纹信息数据
     */
    @Column(name = "fingerprint_data")
    private byte[] fingerprintData;

    @Column(name = "reserve_blob")
    private byte[] reserveBlob;

    /**
     * 获取  
     *
     * @return user_id -   
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置  
     *
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
     * 获取个人平台登录密码
     *
     * @return password - 个人平台登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置个人平台登录密码
     *
     * @param password 个人平台登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return user_mobile
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * @param userMobile
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    /**
     * 获取1 男 2 女 0 未知
     *
     * @return user_sex - 1 男 2 女 0 未知
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * 设置1 男 2 女 0 未知
     *
     * @param userSex 1 男 2 女 0 未知
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取民族
     *
     * @return user_nation - 民族
     */
    public Integer getUserNation() {
        return userNation;
    }

    /**
     * 设置民族
     *
     * @param userNation 民族
     */
    public void setUserNation(Integer userNation) {
        this.userNation = userNation;
    }

    /**
     * @return user_birthday
     */
    public Date getUserBirthday() {
        return userBirthday;
    }

    /**
     * @param userBirthday
     */
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    /**
     * 获取进出限制
     *
     * @return group_id - 进出限制
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 设置进出限制
     *
     * @param groupId 进出限制
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取人员类型：内部人员（1，固定不变），访客(2，固定不变)，陌生人（0，固定不变，非tb_user表中人员）
     *
     * @return user_type - 人员类型：内部人员（1，固定不变），访客(2，固定不变)，陌生人（0，固定不变，非tb_user表中人员）
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置人员类型：内部人员（1，固定不变），访客(2，固定不变)，陌生人（0，固定不变，非tb_user表中人员）
     *
     * @param userType 人员类型：内部人员（1，固定不变），访客(2，固定不变)，陌生人（0，固定不变，非tb_user表中人员）
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
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
     * 获取部门的parent_id
     *
     * @return dept_parent_id - 部门的parent_id
     */
    public Integer getDeptParentId() {
        return deptParentId;
    }

    /**
     * 设置部门的parent_id
     *
     * @param deptParentId 部门的parent_id
     */
    public void setDeptParentId(Integer deptParentId) {
        this.deptParentId = deptParentId;
    }

    /**
     * 获取人员分组（教师，学生，职工）（内部员工，外部人员）（保洁，快递，送餐，司机，开发人员，项目经理，测试人员）
     *
     * @return user_group - 人员分组（教师，学生，职工）（内部员工，外部人员）（保洁，快递，送餐，司机，开发人员，项目经理，测试人员）
     */
    public Integer getUserGroup() {
        return userGroup;
    }

    /**
     * 设置人员分组（教师，学生，职工）（内部员工，外部人员）（保洁，快递，送餐，司机，开发人员，项目经理，测试人员）
     *
     * @param userGroup 人员分组（教师，学生，职工）（内部员工，外部人员）（保洁，快递，送餐，司机，开发人员，项目经理，测试人员）
     */
    public void setUserGroup(Integer userGroup) {
        this.userGroup = userGroup;
    }

    /**
     * 获取是否考勤标志 -0不考勤 -其他是考勤规则ID
     *
     * @return attendance_sign - 是否考勤标志 -0不考勤 -其他是考勤规则ID
     */
    public Integer getAttendanceSign() {
        return attendanceSign;
    }

    /**
     * 设置是否考勤标志 -0不考勤 -其他是考勤规则ID
     *
     * @param attendanceSign 是否考勤标志 -0不考勤 -其他是考勤规则ID
     */
    public void setAttendanceSign(Integer attendanceSign) {
        this.attendanceSign = attendanceSign;
    }

    /**
     * 获取证件、编号类型：身份证-1，军官证-2，护照-3，批量注册编号-4，其他证件-5，客户自定义编号-6
     *
     * @return identification_type - 证件、编号类型：身份证-1，军官证-2，护照-3，批量注册编号-4，其他证件-5，客户自定义编号-6
     */
    public Integer getIdentificationType() {
        return identificationType;
    }

    /**
     * 设置证件、编号类型：身份证-1，军官证-2，护照-3，批量注册编号-4，其他证件-5，客户自定义编号-6
     *
     * @param identificationType 证件、编号类型：身份证-1，军官证-2，护照-3，批量注册编号-4，其他证件-5，客户自定义编号-6
     */
    public void setIdentificationType(Integer identificationType) {
        this.identificationType = identificationType;
    }

    /**
     * 获取证件号码或者编号
     *
     * @return identification_number - 证件号码或者编号
     */
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * 设置证件号码或者编号
     *
     * @param identificationNumber 证件号码或者编号
     */
    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    /**
     * @return id_card
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取比对阈值(针对部分个例人员)
     *
     * @return compare_threshold - 比对阈值(针对部分个例人员)
     */
    public Double getCompareThreshold() {
        return compareThreshold;
    }

    /**
     * 设置比对阈值(针对部分个例人员)
     *
     * @param compareThreshold 比对阈值(针对部分个例人员)
     */
    public void setCompareThreshold(Double compareThreshold) {
        this.compareThreshold = compareThreshold;
    }

    /**
     * 获取访客来访事由
     *
     * @return register_cause - 访客来访事由
     */
    public String getRegisterCause() {
        return registerCause;
    }

    /**
     * 设置访客来访事由
     *
     * @param registerCause 访客来访事由
     */
    public void setRegisterCause(String registerCause) {
        this.registerCause = registerCause;
    }

    /**
     * 获取接待人ID，接待人姓名和电话从tb_user根据此ID取
     *
     * @return receiver_name - 接待人ID，接待人姓名和电话从tb_user根据此ID取
     */
    public Integer getReceiverName() {
        return receiverName;
    }

    /**
     * 设置接待人ID，接待人姓名和电话从tb_user根据此ID取
     *
     * @param receiverName 接待人ID，接待人姓名和电话从tb_user根据此ID取
     */
    public void setReceiverName(Integer receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * 获取访客访问结束时间
     *
     * @return visit_endtime - 访客访问结束时间
     */
    public Date getVisitEndtime() {
        return visitEndtime;
    }

    /**
     * 设置访客访问结束时间
     *
     * @param visitEndtime 访客访问结束时间
     */
    public void setVisitEndtime(Date visitEndtime) {
        this.visitEndtime = visitEndtime;
    }

    /**
     * 获取访客访问开始时间
     *
     * @return visit_starttime - 访客访问开始时间
     */
    public Date getVisitStarttime() {
        return visitStarttime;
    }

    /**
     * 设置访客访问开始时间
     *
     * @param visitStarttime 访客访问开始时间
     */
    public void setVisitStarttime(Date visitStarttime) {
        this.visitStarttime = visitStarttime;
    }

    /**
     * 获取抓拍图片在人员图片表id
     *
     * @return register_pic1_id - 抓拍图片在人员图片表id
     */
    public Long getRegisterPic1Id() {
        return registerPic1Id;
    }

    /**
     * 设置抓拍图片在人员图片表id
     *
     * @param registerPic1Id 抓拍图片在人员图片表id
     */
    public void setRegisterPic1Id(Long registerPic1Id) {
        this.registerPic1Id = registerPic1Id;
    }

    /**
     * 获取抓拍图片在人员图片表id
     *
     * @return register_pic2_id - 抓拍图片在人员图片表id
     */
    public Long getRegisterPic2Id() {
        return registerPic2Id;
    }

    /**
     * 设置抓拍图片在人员图片表id
     *
     * @param registerPic2Id 抓拍图片在人员图片表id
     */
    public void setRegisterPic2Id(Long registerPic2Id) {
        this.registerPic2Id = registerPic2Id;
    }

    /**
     * 获取抓拍图片在人员图片表id
     *
     * @return register_pic3_id - 抓拍图片在人员图片表id
     */
    public Long getRegisterPic3Id() {
        return registerPic3Id;
    }

    /**
     * 设置抓拍图片在人员图片表id
     *
     * @param registerPic3Id 抓拍图片在人员图片表id
     */
    public void setRegisterPic3Id(Long registerPic3Id) {
        this.registerPic3Id = registerPic3Id;
    }

    /**
     * 获取抓拍图片在人员图片表id
     *
     * @return register_pic4_id - 抓拍图片在人员图片表id
     */
    public Long getRegisterPic4Id() {
        return registerPic4Id;
    }

    /**
     * 设置抓拍图片在人员图片表id
     *
     * @param registerPic4Id 抓拍图片在人员图片表id
     */
    public void setRegisterPic4Id(Long registerPic4Id) {
        this.registerPic4Id = registerPic4Id;
    }

    /**
     * 获取删除标记：已删除（1）未删除（0）
     *
     * @return delete_status - 删除标记：已删除（1）未删除（0）
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置删除标记：已删除（1）未删除（0）
     *
     * @param deleteStatus 删除标记：已删除（1）未删除（0）
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 获取Web注册，注册机注册，其他客户端注册，各自代码申请注册方式编码值
     *
     * @return register_method - Web注册，注册机注册，其他客户端注册，各自代码申请注册方式编码值
     */
    public Integer getRegisterMethod() {
        return registerMethod;
    }

    /**
     * 设置Web注册，注册机注册，其他客户端注册，各自代码申请注册方式编码值
     *
     * @param registerMethod Web注册，注册机注册，其他客户端注册，各自代码申请注册方式编码值
     */
    public void setRegisterMethod(Integer registerMethod) {
        this.registerMethod = registerMethod;
    }

    /**
     * 获取审核状态：已审核（1）待审核（0），各自注册方式，根据注册人员分组在tb_pf_audit_conf中的定义确定此列取值
     *
     * @return audit_status - 审核状态：已审核（1）待审核（0），各自注册方式，根据注册人员分组在tb_pf_audit_conf中的定义确定此列取值
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置审核状态：已审核（1）待审核（0），各自注册方式，根据注册人员分组在tb_pf_audit_conf中的定义确定此列取值
     *
     * @param auditStatus 审核状态：已审核（1）待审核（0），各自注册方式，根据注册人员分组在tb_pf_audit_conf中的定义确定此列取值
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取人证比对结果： 人证比对成功（1）人证比对失败（0）非人证比对无结果（-1）
     *
     * @return compare_result - 人证比对结果： 人证比对成功（1）人证比对失败（0）非人证比对无结果（-1）
     */
    public Integer getCompareResult() {
        return compareResult;
    }

    /**
     * 设置人证比对结果： 人证比对成功（1）人证比对失败（0）非人证比对无结果（-1）
     *
     * @param compareResult 人证比对结果： 人证比对成功（1）人证比对失败（0）非人证比对无结果（-1）
     */
    public void setCompareResult(Integer compareResult) {
        this.compareResult = compareResult;
    }

    /**
     * 获取web端编辑人员时，操作人员的系统用户名称
     *
     * @return last_edit_manager - web端编辑人员时，操作人员的系统用户名称
     */
    public String getLastEditManager() {
        return lastEditManager;
    }

    /**
     * 设置web端编辑人员时，操作人员的系统用户名称
     *
     * @param lastEditManager web端编辑人员时，操作人员的系统用户名称
     */
    public void setLastEditManager(String lastEditManager) {
        this.lastEditManager = lastEditManager;
    }

    /**
     * 获取标记批量注册批次
     *
     * @return batch_no - 标记批量注册批次
     */
    public Long getBatchNo() {
        return batchNo;
    }

    /**
     * 设置标记批量注册批次
     *
     * @param batchNo 标记批量注册批次
     */
    public void setBatchNo(Long batchNo) {
        this.batchNo = batchNo;
    }

    /**
     * 获取拼音全拼
     *
     * @return user_name_spell - 拼音全拼
     */
    public String getUserNameSpell() {
        return userNameSpell;
    }

    /**
     * 设置拼音全拼
     *
     * @param userNameSpell 拼音全拼
     */
    public void setUserNameSpell(String userNameSpell) {
        this.userNameSpell = userNameSpell;
    }

    /**
     * 获取拼音简拼
     *
     * @return user_name_short - 拼音简拼
     */
    public String getUserNameShort() {
        return userNameShort;
    }

    /**
     * 设置拼音简拼
     *
     * @param userNameShort 拼音简拼
     */
    public void setUserNameShort(String userNameShort) {
        this.userNameShort = userNameShort;
    }

    /**
     * 获取更新时间
     *
     * @return update_datetime - 更新时间
     */
    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updateDatetime 更新时间
     */
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
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
     * 获取车牌号
     *
     * @return plate_no - 车牌号
     */
    public String getPlateNo() {
        return plateNo;
    }

    /**
     * 设置车牌号
     *
     * @param plateNo 车牌号
     */
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
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
     * @return reserve_vchar1
     */
    public String getReserveVchar1() {
        return reserveVchar1;
    }

    /**
     * @param reserveVchar1
     */
    public void setReserveVchar1(String reserveVchar1) {
        this.reserveVchar1 = reserveVchar1;
    }

    /**
     * @return reserve_vchar2
     */
    public String getReserveVchar2() {
        return reserveVchar2;
    }

    /**
     * @param reserveVchar2
     */
    public void setReserveVchar2(String reserveVchar2) {
        this.reserveVchar2 = reserveVchar2;
    }

    /**
     * @return reserve_vchar3
     */
    public String getReserveVchar3() {
        return reserveVchar3;
    }

    /**
     * @param reserveVchar3
     */
    public void setReserveVchar3(String reserveVchar3) {
        this.reserveVchar3 = reserveVchar3;
    }

    /**
     * @return reserve_vchar4
     */
    public String getReserveVchar4() {
        return reserveVchar4;
    }

    /**
     * @param reserveVchar4
     */
    public void setReserveVchar4(String reserveVchar4) {
        this.reserveVchar4 = reserveVchar4;
    }

    /**
     * @return reserve_vchar5
     */
    public String getReserveVchar5() {
        return reserveVchar5;
    }

    /**
     * @param reserveVchar5
     */
    public void setReserveVchar5(String reserveVchar5) {
        this.reserveVchar5 = reserveVchar5;
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
     * @return reserve_int1
     */
    public Integer getReserveInt1() {
        return reserveInt1;
    }

    /**
     * @param reserveInt1
     */
    public void setReserveInt1(Integer reserveInt1) {
        this.reserveInt1 = reserveInt1;
    }

    /**
     * @return reserve_int2
     */
    public Integer getReserveInt2() {
        return reserveInt2;
    }

    /**
     * @param reserveInt2
     */
    public void setReserveInt2(Integer reserveInt2) {
        this.reserveInt2 = reserveInt2;
    }

    /**
     * @return reserve_int3
     */
    public Integer getReserveInt3() {
        return reserveInt3;
    }

    /**
     * @param reserveInt3
     */
    public void setReserveInt3(Integer reserveInt3) {
        this.reserveInt3 = reserveInt3;
    }

    /**
     * @return reserve_int4
     */
    public Integer getReserveInt4() {
        return reserveInt4;
    }

    /**
     * @param reserveInt4
     */
    public void setReserveInt4(Integer reserveInt4) {
        this.reserveInt4 = reserveInt4;
    }

    /**
     * @return reserve_int5
     */
    public Integer getReserveInt5() {
        return reserveInt5;
    }

    /**
     * @param reserveInt5
     */
    public void setReserveInt5(Integer reserveInt5) {
        this.reserveInt5 = reserveInt5;
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
     * 获取证件图片在人员图片表中的id
     *
     * @return identification_pic_id - 证件图片在人员图片表中的id
     */
    public byte[] getIdentificationPicId() {
        return identificationPicId;
    }

    /**
     * 设置证件图片在人员图片表中的id
     *
     * @param identificationPicId 证件图片在人员图片表中的id
     */
    public void setIdentificationPicId(byte[] identificationPicId) {
        this.identificationPicId = identificationPicId;
    }

    /**
     * 获取抓拍图片在人员图片1路径
     *
     * @return register_pic1_path - 抓拍图片在人员图片1路径
     */
    public byte[] getRegisterPic1Path() {
        return registerPic1Path;
    }

    /**
     * 设置抓拍图片在人员图片1路径
     *
     * @param registerPic1Path 抓拍图片在人员图片1路径
     */
    public void setRegisterPic1Path(byte[] registerPic1Path) {
        this.registerPic1Path = registerPic1Path;
    }

    /**
     * 获取抓拍图片在人员图片2路径
     *
     * @return register_pic2_path - 抓拍图片在人员图片2路径
     */
    public byte[] getRegisterPic2Path() {
        return registerPic2Path;
    }

    /**
     * 设置抓拍图片在人员图片2路径
     *
     * @param registerPic2Path 抓拍图片在人员图片2路径
     */
    public void setRegisterPic2Path(byte[] registerPic2Path) {
        this.registerPic2Path = registerPic2Path;
    }

    /**
     * 获取抓拍图片在人员图片3路径
     *
     * @return register_pic3_path - 抓拍图片在人员图片3路径
     */
    public byte[] getRegisterPic3Path() {
        return registerPic3Path;
    }

    /**
     * 设置抓拍图片在人员图片3路径
     *
     * @param registerPic3Path 抓拍图片在人员图片3路径
     */
    public void setRegisterPic3Path(byte[] registerPic3Path) {
        this.registerPic3Path = registerPic3Path;
    }

    /**
     * 获取抓拍图片在人员图片4路径
     *
     * @return register_pic4_path - 抓拍图片在人员图片4路径
     */
    public byte[] getRegisterPic4Path() {
        return registerPic4Path;
    }

    /**
     * 设置抓拍图片在人员图片4路径
     *
     * @param registerPic4Path 抓拍图片在人员图片4路径
     */
    public void setRegisterPic4Path(byte[] registerPic4Path) {
        this.registerPic4Path = registerPic4Path;
    }

    /**
     * 获取指纹信息数据
     *
     * @return fingerprint_data - 指纹信息数据
     */
    public byte[] getFingerprintData() {
        return fingerprintData;
    }

    /**
     * 设置指纹信息数据
     *
     * @param fingerprintData 指纹信息数据
     */
    public void setFingerprintData(byte[] fingerprintData) {
        this.fingerprintData = fingerprintData;
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