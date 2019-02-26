package com.czht.smartpark.tbweb.modular.dmo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_third_oa_duty")
public class ThirdDuty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "dutyLeader")
    private String dutyleader;

    @Column(name = "createdTime")
    private Date createdtime;

    @Column(name = "dutyAmy")
    private String dutyamy;

    @Column(name = "modifiedTime")
    private Date modifiedtime;

    @Column(name = "dutyOffice")
    private String dutyoffice;

    @Column(name = "typeName")
    private String typename;

    private Date date;

    @Column(name = "zoneId")
    private String zoneid;

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
     * @return dutyLeader
     */
    public String getDutyleader() {
        return dutyleader;
    }

    /**
     * @param dutyleader
     */
    public void setDutyleader(String dutyleader) {
        this.dutyleader = dutyleader;
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
     * @return dutyAmy
     */
    public String getDutyamy() {
        return dutyamy;
    }

    /**
     * @param dutyamy
     */
    public void setDutyamy(String dutyamy) {
        this.dutyamy = dutyamy;
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
     * @return dutyOffice
     */
    public String getDutyoffice() {
        return dutyoffice;
    }

    /**
     * @param dutyoffice
     */
    public void setDutyoffice(String dutyoffice) {
        this.dutyoffice = dutyoffice;
    }

    /**
     * @return typeName
     */
    public String getTypename() {
        return typename;
    }

    /**
     * @param typename
     */
    public void setTypename(String typename) {
        this.typename = typename;
    }

    /**
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
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
}