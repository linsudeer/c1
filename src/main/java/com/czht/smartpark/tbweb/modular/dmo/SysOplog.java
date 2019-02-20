package com.czht.smartpark.tbweb.modular.dmo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sys_oplog")
public class SysOplog {
    /**
     * 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 通行记录ID
     */
    @Column(name = "pass_record_id")
    private Long passRecordId;

    /**
     * 用户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 模块名
     */
    @Column(name = "module_name")
    private String moduleName;

    /**
     * 操作类型
     */
    @Column(name = "opt_type")
    private String optType;

    /**
     * 描述
     */
    @Column(name = "opt_content")
    private String optContent;

    /**
     * 参数
     */
    @Column(name = "opt_detail")
    private String optDetail;

    /**
     * IP
     */
    @Column(name = "client_ipaddress")
    private String clientIpaddress;

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
     * 获取通行记录ID
     *
     * @return pass_record_id - 通行记录ID
     */
    public Long getPassRecordId() {
        return passRecordId;
    }

    /**
     * 设置通行记录ID
     *
     * @param passRecordId 通行记录ID
     */
    public void setPassRecordId(Long passRecordId) {
        this.passRecordId = passRecordId;
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
     * 获取模块名
     *
     * @return module_name - 模块名
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 设置模块名
     *
     * @param moduleName 模块名
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * 获取操作类型
     *
     * @return opt_type - 操作类型
     */
    public String getOptType() {
        return optType;
    }

    /**
     * 设置操作类型
     *
     * @param optType 操作类型
     */
    public void setOptType(String optType) {
        this.optType = optType;
    }

    /**
     * 获取描述
     *
     * @return opt_content - 描述
     */
    public String getOptContent() {
        return optContent;
    }

    /**
     * 设置描述
     *
     * @param optContent 描述
     */
    public void setOptContent(String optContent) {
        this.optContent = optContent;
    }

    /**
     * 获取参数
     *
     * @return opt_detail - 参数
     */
    public String getOptDetail() {
        return optDetail;
    }

    /**
     * 设置参数
     *
     * @param optDetail 参数
     */
    public void setOptDetail(String optDetail) {
        this.optDetail = optDetail;
    }

    /**
     * 获取IP
     *
     * @return client_ipaddress - IP
     */
    public String getClientIpaddress() {
        return clientIpaddress;
    }

    /**
     * 设置IP
     *
     * @param clientIpaddress IP
     */
    public void setClientIpaddress(String clientIpaddress) {
        this.clientIpaddress = clientIpaddress;
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