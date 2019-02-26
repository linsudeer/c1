package com.czht.smartpark.tbweb.modular.dmo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_third_oa_leavetype")
public class ThirdLeavetype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String icon;

    @Column(name = "createdTime")
    private Date createdtime;

    private String alias;

    private Long sequence;

    @Column(name = "modifiedTime")
    private Date modifiedtime;

    @Column(name = "formName")
    private String formname;

    private String name;

    @Column(name = "limitDays")
    private Boolean limitdays;

    private Long mode;

    private String color;

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
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
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
     * @return alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
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
     * @return formName
     */
    public String getFormname() {
        return formname;
    }

    /**
     * @param formname
     */
    public void setFormname(String formname) {
        this.formname = formname;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return limitDays
     */
    public Boolean getLimitdays() {
        return limitdays;
    }

    /**
     * @param limitdays
     */
    public void setLimitdays(Boolean limitdays) {
        this.limitdays = limitdays;
    }

    /**
     * @return mode
     */
    public Long getMode() {
        return mode;
    }

    /**
     * @param mode
     */
    public void setMode(Long mode) {
        this.mode = mode;
    }

    /**
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }
}