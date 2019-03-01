package com.czht.smartpark.tbweb.modular.dto;

/**
 * TB办公系统用户表
 */
public class ThirdOaUserDTO {
    private String id;
    private String alias;
    private String name;
    private String departPostion;
    private Boolean isOnline;
    private String organId;
    private String organName;
    private String organPath;
    private Integer sequnece;
    private String zoneId;
    private String accountName;

    public ThirdOaUserDTO(String accountName){
        this.accountName = accountName;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartPostion() {
        return departPostion;
    }
    public void setDepartPostion(String departPostion) {
        this.departPostion = departPostion;
    }
    public Boolean getIsOnline() {
        return isOnline;
    }
    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }
    public String getOrganId() {
        return organId;
    }
    public void setOrganId(String organId) {
        this.organId = organId;
    }
    public String getOrganName() {
        return organName;
    }
    public void setOrganName(String organName) {
        this.organName = organName;
    }
    public String getOrganPath() {
        return organPath;
    }
    public void setOrganPath(String organPath) {
        this.organPath = organPath;
    }
    public Integer getSequnece() {
        return sequnece;
    }
    public void setSequnece(Integer sequnece) {
        this.sequnece = sequnece;
    }
    public String getZoneId() {
        return zoneId;
    }
    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
