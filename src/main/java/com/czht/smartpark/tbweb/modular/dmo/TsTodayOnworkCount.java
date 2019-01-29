package com.czht.smartpark.tbweb.modular.dmo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ts_today_onwork_count")
public class TsTodayOnworkCount {
    @Id
    @Column(name = "record_id")
    private Long recordId;

    @Column(name = "data_time")
    private String dataTime;

    @Column(name = "data_count")
    private Long dataCount;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 临时字段
     */
    @Column(name = "data_desc")
    private String dataDesc;

    /**
     * 区域类型
     */
    @Column(name = "area_id")
    private String areaId;

    /**
     * 部门id
     */
    @Column(name = "dept_id")
    private String deptId;

    /**
     * @return record_id
     */
    public Long getRecordId() {
        return recordId;
    }

    /**
     * @param recordId
     */
    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    /**
     * @return data_time
     */
    public String getDataTime() {
        return dataTime;
    }

    /**
     * @param dataTime
     */
    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    /**
     * @return data_count
     */
    public Long getDataCount() {
        return dataCount;
    }

    /**
     * @param dataCount
     */
    public void setDataCount(Long dataCount) {
        this.dataCount = dataCount;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取临时字段
     *
     * @return data_desc - 临时字段
     */
    public String getDataDesc() {
        return dataDesc;
    }

    /**
     * 设置临时字段
     *
     * @param dataDesc 临时字段
     */
    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc;
    }

    /**
     * 获取区域类型
     *
     * @return area_id - 区域类型
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 设置区域类型
     *
     * @param areaId 区域类型
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取部门id
     *
     * @return dept_id - 部门id
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * 设置部门id
     *
     * @param deptId 部门id
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}