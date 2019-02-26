package com.czht.smartpark.tbweb.modular.dmo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_third_oa_dutyuser")
public class ThirdDutyuser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "createdTime")
    private Date createdtime;

    private Long sequence;

    @Column(name = "modifiedTime")
    private Date modifiedtime;

    @Column(name = "userId")
    private String userid;

    @Column(name = "userName")
    private String username;

    @Column(name = "dutyId")
    private String dutyid;

    @Column(name = "isLeader")
    private Boolean isleader;

    @Column(name = "canPass")
    private Boolean canpass;

    @Column(name = "dutyTypeUserId")
    private String dutytypeuserid;

    @Column(name = "isArrange")
    private Boolean isarrange;

    @Column(name = "organId")
    private String organid;

    @Column(name = "organName")
    private String organname;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return createdTime
     */
    public Date getCreatedtime() {
        return createdtime;
    }

    /**
     * @param createdtime
     */
    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    /**
     * @return sequence
     */
    public Long getSequence() {
        return sequence;
    }

    /**
     * @param sequence
     */
    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    /**
     * @return modifiedTime
     */
    public Date getModifiedtime() {
        return modifiedtime;
    }

    /**
     * @param modifiedtime
     */
    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    /**
     * @return userId
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return dutyId
     */
    public String getDutyid() {
        return dutyid;
    }

    /**
     * @param dutyid
     */
    public void setDutyid(String dutyid) {
        this.dutyid = dutyid;
    }

    /**
     * @return isLeader
     */
    public Boolean getIsleader() {
        return isleader;
    }

    /**
     * @param isleader
     */
    public void setIsleader(Boolean isleader) {
        this.isleader = isleader;
    }

    /**
     * @return canPass
     */
    public Boolean getCanpass() {
        return canpass;
    }

    /**
     * @param canpass
     */
    public void setCanpass(Boolean canpass) {
        this.canpass = canpass;
    }

    /**
     * @return dutyTypeUserId
     */
    public String getDutytypeuserid() {
        return dutytypeuserid;
    }

    /**
     * @param dutytypeuserid
     */
    public void setDutytypeuserid(String dutytypeuserid) {
        this.dutytypeuserid = dutytypeuserid;
    }

    /**
     * @return isArrange
     */
    public Boolean getIsarrange() {
        return isarrange;
    }

    /**
     * @param isarrange
     */
    public void setIsarrange(Boolean isarrange) {
        this.isarrange = isarrange;
    }

    /**
     * @return organId
     */
    public String getOrganid() {
        return organid;
    }

    /**
     * @param organid
     */
    public void setOrganid(String organid) {
        this.organid = organid;
    }

    /**
     * @return organName
     */
    public String getOrganname() {
        return organname;
    }

    /**
     * @param organname
     */
    public void setOrganname(String organname) {
        this.organname = organname;
    }
}