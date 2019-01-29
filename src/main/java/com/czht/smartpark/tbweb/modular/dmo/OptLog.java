package com.czht.smartpark.tbweb.modular.dmo;

import javax.persistence.*;
import java.util.Date;
@Table(name = "tb_opt_Log")
public class OptLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "opt_type")
    private String optType;

    @Column(name = "opt_content")
    private String optContent;

    @Column(name = "opt_detail")
    private String optDetail;

    @Column(name = "client_ipaddress")
    private String clientIpaddress;

    @Column(name = "opt_time")
    private Date optTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType == null ? null : optType.trim();
    }

    public String getOptContent() {
        return optContent;
    }

    public void setOptContent(String optContent) {
        this.optContent = optContent == null ? null : optContent.trim();
    }

    public String getOptDetail() {
        return optDetail;
    }

    public void setOptDetail(String optDetail) {
        this.optDetail = optDetail == null ? null : optDetail.trim();
    }

    public String getClientIpaddress() {
        return clientIpaddress;
    }

    public void setClientIpaddress(String clientIpaddress) {
        this.clientIpaddress = clientIpaddress == null ? null : clientIpaddress.trim();
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }
}