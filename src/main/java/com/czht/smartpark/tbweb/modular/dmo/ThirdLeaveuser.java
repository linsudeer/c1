package com.czht.smartpark.tbweb.modular.dmo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_third_oa_leaveuser")
public class ThirdLeaveuser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String position;

    @Column(name = "organId")
    private String organid;

    @Column(name = "cancelUserId")
    private String canceluserid;

    private Integer count;

    @Column(name = "createdTime")
    private Date createdtime;

    @Column(name = "modifiedTime")
    private Date modifiedtime;

    @Column(name = "beginTime")
    private Date begintime;

    @Column(name = "cancelContent")
    private String cancelcontent;

    @Column(name = "cancelLeave")
    private String cancelleave;

    @Column(name = "endTime")
    private Date endtime;

    @Column(name = "zoneName")
    private String zonename;

    @Column(name = "leaveType")
    private String leavetype;

    @Column(name = "zoneId")
    private String zoneid;

    @Column(name = "cancelLeaveTime")
    private Date cancelleavetime;

    @Column(name = "directorAble")
    private String directorable;

    @Column(name = "userId")
    private String userid;

    @Column(name = "cancelUserName")
    private String cancelusername;

    @Column(name = "userName")
    private String username;

    @Column(name = "requisitionId")
    private String requisitionid;

    @Column(name = "organName")
    private String organname;

    private String converting;

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
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
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
     * @return cancelUserId
     */
    public String getCanceluserid() {
        return canceluserid;
    }

    /**
     * @param canceluserid
     */
    public void setCanceluserid(String canceluserid) {
        this.canceluserid = canceluserid;
    }

    /**
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
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
     * @return beginTime
     */
    public Date getBegintime() {
        return begintime;
    }

    /**
     * @param begintime
     */
    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    /**
     * @return cancelContent
     */
    public String getCancelcontent() {
        return cancelcontent;
    }

    /**
     * @param cancelcontent
     */
    public void setCancelcontent(String cancelcontent) {
        this.cancelcontent = cancelcontent;
    }

    /**
     * @return cancelLeave
     */
    public String getCancelleave() {
        return cancelleave;
    }

    /**
     * @param cancelleave
     */
    public void setCancelleave(String cancelleave) {
        this.cancelleave = cancelleave;
    }

    /**
     * @return endTime
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * @param endtime
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * @return zoneName
     */
    public String getZonename() {
        return zonename;
    }

    /**
     * @param zonename
     */
    public void setZonename(String zonename) {
        this.zonename = zonename;
    }

    /**
     * @return leaveType
     */
    public String getLeavetype() {
        return leavetype;
    }

    /**
     * @param leavetype
     */
    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype;
    }

    /**
     * @return zoneId
     */
    public String getZoneid() {
        return zoneid;
    }

    /**
     * @param zoneid
     */
    public void setZoneid(String zoneid) {
        this.zoneid = zoneid;
    }

    /**
     * @return cancelLeaveTime
     */
    public Date getCancelleavetime() {
        return cancelleavetime;
    }

    /**
     * @param cancelleavetime
     */
    public void setCancelleavetime(Date cancelleavetime) {
        this.cancelleavetime = cancelleavetime;
    }

    /**
     * @return directorAble
     */
    public String getDirectorable() {
        return directorable;
    }

    /**
     * @param directorable
     */
    public void setDirectorable(String directorable) {
        this.directorable = directorable;
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
     * @return cancelUserName
     */
    public String getCancelusername() {
        return cancelusername;
    }

    /**
     * @param cancelusername
     */
    public void setCancelusername(String cancelusername) {
        this.cancelusername = cancelusername;
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
     * @return requisitionId
     */
    public String getRequisitionid() {
        return requisitionid;
    }

    /**
     * @param requisitionid
     */
    public void setRequisitionid(String requisitionid) {
        this.requisitionid = requisitionid;
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

    /**
     * @return converting
     */
    public String getConverting() {
        return converting;
    }

    /**
     * @param converting
     */
    public void setConverting(String converting) {
        this.converting = converting;
    }
}