package com.czht.smartpark.tbweb.modular.dmo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_pf_area")
public class Area {
    @Id
    @Column(name = "area_id")
    private Integer areaId;

    @Column(name = "area_name")
    private String areaName;

    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 在同一父节点下面的显示顺序
     */
    @Column(name = "sort_no")
    private Integer sortNo;

    /**
     * 无权限的报警级别
     */
    @Column(name = "alarm_level")
    private Integer alarmLevel;

    /**
     * 未注册的报警级别
     */
    @Column(name = "alarm_level2")
    private Integer alarmLevel2;

    /**
     * 未识别的报警级别
     */
    @Column(name = "alarm_level3")
    private Integer alarmLevel3;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 区域类型
     */
    @Column(name = "area_type")
    private Integer areaType;

    private BigDecimal lng;

    private BigDecimal lat;

    /**
     * @return area_id
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * @param areaId
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * @return area_name
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * @param areaName
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取在同一父节点下面的显示顺序
     *
     * @return sort_no - 在同一父节点下面的显示顺序
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * 设置在同一父节点下面的显示顺序
     *
     * @param sortNo 在同一父节点下面的显示顺序
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * 获取无权限的报警级别
     *
     * @return alarm_level - 无权限的报警级别
     */
    public Integer getAlarmLevel() {
        return alarmLevel;
    }

    /**
     * 设置无权限的报警级别
     *
     * @param alarmLevel 无权限的报警级别
     */
    public void setAlarmLevel(Integer alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    /**
     * 获取未注册的报警级别
     *
     * @return alarm_level2 - 未注册的报警级别
     */
    public Integer getAlarmLevel2() {
        return alarmLevel2;
    }

    /**
     * 设置未注册的报警级别
     *
     * @param alarmLevel2 未注册的报警级别
     */
    public void setAlarmLevel2(Integer alarmLevel2) {
        this.alarmLevel2 = alarmLevel2;
    }

    /**
     * 获取未识别的报警级别
     *
     * @return alarm_level3 - 未识别的报警级别
     */
    public Integer getAlarmLevel3() {
        return alarmLevel3;
    }

    /**
     * 设置未识别的报警级别
     *
     * @param alarmLevel3 未识别的报警级别
     */
    public void setAlarmLevel3(Integer alarmLevel3) {
        this.alarmLevel3 = alarmLevel3;
    }

    /**
     * 获取创建时间
     *
     * @return created - 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置创建时间
     *
     * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取更新时间
     *
     * @return updated - 更新时间
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * 设置更新时间
     *
     * @param updated 更新时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * 获取区域类型
     *
     * @return area_type - 区域类型
     */
    public Integer getAreaType() {
        return areaType;
    }

    /**
     * 设置区域类型
     *
     * @param areaType 区域类型
     */
    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    /**
     * @return lng
     */
    public BigDecimal getLng() {
        return lng;
    }

    /**
     * @param lng
     */
    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    /**
     * @return lat
     */
    public BigDecimal getLat() {
        return lat;
    }

    /**
     * @param lat
     */
    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }
}