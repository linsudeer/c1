package com.czht.smartpark.tbweb.modular.dmo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_pass_record_optlog")
public class passRecordOptlog {
    /**
     * 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 记录id
     */
    @Column(name = "pass_record_id")
    private Long passRecordId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 操作类型 修改，新增
     */
    private String type;

    /**
     * 描述
     */
    private String remark;

    /**
     * 操作时间
     */
    @Column(name = "opt_time")
    private Date optTime;

    /**
     * 获取自增
     *
     * @return id - 自增
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增
     *
     * @param id 自增
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取记录id
     *
     * @return pass_record_id - 记录id
     */
    public Long getPassRecordId() {
        return passRecordId;
    }

    /**
     * 设置记录id
     *
     * @param passRecordId 记录id
     */
    public void setPassRecordId(Long passRecordId) {
        this.passRecordId = passRecordId;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户姓名
     *
     * @return user_name - 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名
     *
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取操作类型 修改，新增
     *
     * @return type - 操作类型 修改，新增
     */
    public String getType() {
        return type;
    }

    /**
     * 设置操作类型 修改，新增
     *
     * @param type 操作类型 修改，新增
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取描述
     *
     * @return remark - 描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置描述
     *
     * @param remark 描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取操作时间
     *
     * @return opt_time - 操作时间
     */
    public Date getOptTime() {
        return optTime;
    }

    /**
     * 设置操作时间
     *
     * @param optTime 操作时间
     */
    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }
}